package ginie.scheduler;

import com.google.inject.Inject;
import ginie.GinieException;
import ginie.boot.CommandOptions;
import ginie.mongo.service.MongoServices;
import ginie.service.AbstractLifeCycleService;
import ginie.settings.GinieSettings;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Created by dhruvr on 6/8/16.
 */
public class SchedulerServiceImpl extends AbstractLifeCycleService<SchedulerService> implements SchedulerService {

    private final Scheduler scheduler;
    private final MongoServices mongoServices;
    private final SchedulerServiceListener listener;

    @Inject
    public SchedulerServiceImpl(GinieSettings ginieSettings,
                                CommandOptions commandOptions,
                                Scheduler scheduler,
                                MongoServices mongoServices,
                                SchedulerServiceListener listener) {
        super(ginieSettings, commandOptions);
        this.scheduler = scheduler;
        this.mongoServices = mongoServices;
        this.listener = listener;
    }

    @Override
    protected void dostart() throws GinieException {
        startScheduler();
        addLifeCycleListener(listener);
    }

    @Override
    protected void dostop() throws GinieException {
        if (!lifeCycle.canMoveToStopped()) {
            stopScheduler();
        }
        lifeCycle.moveToClosed();
    }

    @Override
    protected void doClose() throws GinieException {
        if (!lifeCycle.canMoveToClosed()) {
            stopScheduler();
        }
        lifeCycle.closed();
    }

    @Override
    public void startScheduler() throws GinieException {
        try {
            final JobDetail jobDetail = newJob(MongoUpdater.class)
                    .withIdentity("mongoupdaterJob", "mongoupdaterGroup")
                    .build();

            jobDetail.getJobDataMap().put("mongoServices", mongoServices);

            Trigger trigger = newTrigger()
                    .withIdentity("workkardAgingTrigger", "workkardGroup")
                    .startNow()
                    .withSchedule(CronScheduleBuilder.cronSchedule(ginieSettings.get("quartz.cron.expression", "0 0/5 * * * ?")))
                    .build();

            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
        } catch (Exception e) {
            throw new GinieException("Problem while starting scheduler ", e);
        }

    }

    @Override
    public void stopScheduler() throws GinieException {
        try {
            scheduler.shutdown(true);
        } catch (Exception e) {
            throw new GinieException("Problem in stopping scheduler ", e);
        }
    }

    @Override
    public void closeScheduler() throws GinieException {
        try {
            scheduler.shutdown(true);
        } catch (Exception e) {
            throw new GinieException("Problem in closing scheduler ", e);
        }

    }
}
