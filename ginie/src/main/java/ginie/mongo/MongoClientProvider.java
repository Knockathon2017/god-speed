package ginie.mongo;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.mongodb.MongoClient;
import ginie.settings.GinieSettings;

/**
 * Created by dhruvr on 5/8/16.
 */
public class MongoClientProvider implements Provider<MongoClient> {

    private static MongoClient mongoClient;


    @Inject
    public MongoClientProvider(GinieSettings settings) {
        if (mongoClient == null) {
            mongoClient = createMongo(settings);
        }
    }

    @Override
    public MongoClient get() {
        return mongoClient;
    }

    private MongoClient createMongo(final GinieSettings settings) {
        String host = settings.get("mongo.host", "127.0.0.1");
        int port = settings.getAsInt("mongo.port", 27017);
        return new MongoClient(host, port);
    }
}
