package ginie.mongo;

import com.google.inject.AbstractModule;
import com.mongodb.MongoClient;
import ginie.mongo.repository.MicrosInfoRepo;
import ginie.mongo.repository.MicrosInfoRepoImpl;
import ginie.mongo.service.MongoServices;
import ginie.mongo.service.MongoServicesImpl;

/**
 * Created by dhruvr on 5/8/16.
 */
public class MongoModule extends AbstractModule {


    @Override
    protected void configure() {

        bind(MongoClient.class).toProvider(MongoClientProvider.class).asEagerSingleton();
        bind(MongoServices.class).to(MongoServicesImpl.class).asEagerSingleton();
        bind(MicrosInfoRepo.class).to(MicrosInfoRepoImpl.class).asEagerSingleton();
    }
}
