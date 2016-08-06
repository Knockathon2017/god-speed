package ginie.scheduler;

import com.google.inject.Inject;
import ginie.GinieException;
import ginie.settings.GinieSettings;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

import javax.inject.Provider;
import java.util.Properties;

/**
 * Created by dhruvr on 6/8/16.
 */
public class SchedulerProvider implements Provider<Scheduler> {


    private static Scheduler scheduler;

    @Inject
    public SchedulerProvider(GinieSettings settings) throws GinieException {

        if (scheduler == null) {
            Properties props = new Properties();
            props.setProperty("org.quartz.scheduler.skipUpdateCheck", settings.get("org.quartz.scheduler.skipUpdateCheck", "true"));
            props.setProperty("org.quartz.jobStore.class", "org.quartz.simpl.RAMJobStore");
            props.setProperty("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
            props.setProperty("org.quartz.threadPool.threadCount", settings.get("org.quartz.threadPool.threadCount", "10"));


            try {
                scheduler = new StdSchedulerFactory(props).getScheduler();
            } catch (Exception e) {
                throw new GinieException("Problem while initilizing scheduler", e);
            }
        }
    }

    @Override
    public Scheduler get() {
        return scheduler;
    }
}
