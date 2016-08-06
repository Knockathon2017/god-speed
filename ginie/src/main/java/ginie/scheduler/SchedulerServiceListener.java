package ginie.scheduler;

import ginie.server.ServerServiceListener;
import ginie.service.LifeCycleListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by dhruvr on 6/8/16.
 */
public class SchedulerServiceListener implements LifeCycleListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerServiceListener.class);

    @Override
    public void beforeStart() {

    }

    @Override
    public void afterStart() {
        LOGGER.info("\t\t SchedulerService service started");
    }

    @Override
    public void beforeStop() {

    }

    @Override
    public void afterStop() {
        LOGGER.info("\t\t SchedulerService service stopped ");
    }

    @Override
    public void beforeClose() {

    }

    @Override
    public void afterClose() {
        LOGGER.info("\t\t SchedulerService service closed");
    }
}
