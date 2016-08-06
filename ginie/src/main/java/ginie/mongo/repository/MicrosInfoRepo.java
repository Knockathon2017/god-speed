package ginie.mongo.repository;

import com.mongodb.client.FindIterable;
import ginie.mongo.entities.MicroInfo;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * Created by dhruvr on 5/8/16.
 */
public interface MicrosInfoRepo {

    FindIterable<Document> getAll();

    FindIterable<Document> getByTags(List<String> tags);

    void save(MicroInfo microInfo);

    FindIterable<Document> getActiveByTag(String tag);

    void updateStatus(ObjectId idValue, String status);

}
