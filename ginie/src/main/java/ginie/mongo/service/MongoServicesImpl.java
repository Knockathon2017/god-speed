package ginie.mongo.service;

import com.google.inject.Inject;
import com.mongodb.Block;
import ginie.GinieException;
import ginie.common.JsonUtils;
import ginie.common.NullUtils;
import ginie.mongo.entities.MicroInfo;
import ginie.mongo.repository.MicrosInfoRepo;
import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by dhruvr on 5/8/16.
 */
public class MongoServicesImpl implements MongoServices {


    private final MicrosInfoRepo repo;

    @Inject
    public MongoServicesImpl(MicrosInfoRepo repo) {
        this.repo = repo;
    }

    @Override
    public void insertMicroInfo(JSONObject jsonObject) throws GinieException {
        try {

            String ip = jsonObject.getString("ip");
            String port = jsonObject.getString("port");
            String url = jsonObject.getString("url");
            JSONArray tagJsonArray = (JSONArray) jsonObject.get("tags");
            String logPath = jsonObject.getString("logPath");
            String status = jsonObject.getString("status");

            NullUtils.checkNotBlank(ip, port, url, logPath, status);

            List<String> tags = JsonUtils.getList(tagJsonArray);
            NullUtils.checkNotEmpty(tags);

            MicroInfo m = new MicroInfo();

            m.setIP(ip);
            m.setUrl(url);
            m.setPort(port);
            m.setLogPath(logPath);
            m.setTags(tags);
            m.setStatus(status);

            repo.save(m);

        } catch (Exception e) {
            throw new GinieException("Problem in saving MicroInfo ", e);
        }
    }

    @Override
    public JSONArray listAllMicrosInfo() {
        final JSONArray jsonArray = new JSONArray();
        repo.getAll().forEach((Block<Document>) jsonArray::put);
        return jsonArray;
    }

    @Override
    public JSONArray getMicroByTag(JSONObject jsonObject) {
        JSONArray result = new JSONArray();
        JSONArray inputJsonArray = jsonObject.getJSONArray("tags");
        List<String> tags = JsonUtils.getList(inputJsonArray);
        repo.getByTags(tags).forEach((Block<Document>) (value) -> {
            result.put(value);
        });
        return result;
    }

}
