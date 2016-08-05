package ginie.service;

import com.google.inject.AbstractModule;
import ginie.server.ServerService;
import ginie.server.ServerServiceImpl;

/**
 * Created by dhruvr
 */
public class ServiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ServerService.class).to(ServerServiceImpl.class).asEagerSingleton();
    }
}
