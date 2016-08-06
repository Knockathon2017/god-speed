package ginie.scheduler;

import ginie.common.JobUtils;
import ginie.mongo.service.MongoServices;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by dhruvr on 6/8/16.
 */
public class MongoUpdater implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            JobDataMap jobDetail = context.getJobDetail().getJobDataMap();
            MongoServices mongoServices = JobUtils.<MongoServices>getValue(jobDetail, "mongoServices");
            mongoServices.updateStatus();
        } catch (Exception e) {
            throw new JobExecutionException("Problem while executing job ", e);
        }
    }
}
