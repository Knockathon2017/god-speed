package ginie.scheduler;

import com.google.inject.AbstractModule;
import org.quartz.Scheduler;

/**
 * Created by dhruvr on 6/8/16.
 */
public class SchedulerModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(Scheduler.class).toProvider(SchedulerProvider.class).asEagerSingleton();
        bind(SchedulerService.class).to(SchedulerServiceImpl.class).asEagerSingleton();
        bind(SchedulerServiceListener.class).asEagerSingleton();
    }
}
