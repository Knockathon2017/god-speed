package ginie.mongo.repository;

import com.google.inject.Inject;
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import ginie.mongo.entities.MicroInfo;
import ginie.settings.GinieSettings;
import org.bson.Document;

import java.util.List;

/**
 * Created by dhruvr on 5/8/16.
 */
public class MicrosInfoRepoImpl implements MicrosInfoRepo {


    private final String collectionName;
    private final MongoClient client;
    private final String mongoDatabaseName;
    private final MongoDatabase mongoDatabase;
    private final MongoCollection<Document> mongoCollection;

    @Inject
    public MicrosInfoRepoImpl(GinieSettings settings, MongoClient client) {
        this.client = client;
        this.mongoDatabaseName = settings.get("mongo.db.name", "aladin");
        this.collectionName = settings.get("mongo.micro.collection.name", "microsInfo");
        this.mongoDatabase = client.getDatabase(mongoDatabaseName);
        this.mongoCollection = mongoDatabase.getCollection(collectionName);
    }

    @Override
    public FindIterable<Document> getAll() {
        return mongoCollection.find();
    }

    @Override
    public  FindIterable<Document> getByTags(List<String> tags) {
       return mongoCollection.find(Filters.in("tags", tags));
    }

    @Override
    public void save(MicroInfo microInfo) {
        Document document = microInfo.createDocumentInsert();
        mongoCollection.insertOne(document);
    }

}
