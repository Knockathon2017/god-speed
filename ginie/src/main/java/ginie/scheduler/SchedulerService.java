package ginie.scheduler;

import ginie.GinieException;
import ginie.service.ServiceCycle;

/**
 * Created by dhruvr on 6/8/16.
 */
public interface SchedulerService extends ServiceCycle<SchedulerService> {

    void startScheduler() throws GinieException;

    void stopScheduler() throws GinieException;

    void closeScheduler() throws GinieException;

}
