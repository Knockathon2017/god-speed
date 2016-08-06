package ginie.mongo.service;

import com.google.inject.Inject;
import com.mongodb.Block;
import ginie.GinieException;
import ginie.common.JsonUtils;
import ginie.httpclient.GinieHttpClient;
import ginie.mongo.entities.MicroInfo;
import ginie.mongo.repository.MicrosInfoRepo;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dhruvr on 5/8/16.
 */
public class MongoServicesImpl implements MongoServices {


    private final MicrosInfoRepo repo;
    private final GinieHttpClient ginieHttpClient;
    private static final Logger LOGGER = LoggerFactory.getLogger(MongoServicesImpl.class);

    @Inject
    public MongoServicesImpl(MicrosInfoRepo repo, GinieHttpClient ginieHttpClient) {
        this.repo = repo;
        this.ginieHttpClient = ginieHttpClient;
    }

    @Override
    public void insertMicroInfo(JSONObject jsonObject) throws GinieException {
        try {

            String ip = jsonObject.getString("ip");
            String url = jsonObject.getString("url");
            JSONArray tagJsonArray = (JSONArray) jsonObject.get("tags");
            String logPath = jsonObject.getString("logPath");
            String status = jsonObject.getString("status");
            String serviceName = jsonObject.getString("serviceName");
            String methodUrl = jsonObject.getString("methodUrl");

//            NullUtils.checkNotBlank(ip, port, url, logPath, status);

            List<String> tags = JsonUtils.getListInLower(tagJsonArray);
//            NullUtils.checkNotEmpty(tags);

            MicroInfo m = new MicroInfo();

            m.setIP(ip);
            m.setUrl(url);
            m.setMethodUrl(methodUrl);
            m.setServiceName(serviceName);
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
        List<String> tags = JsonUtils.getListInLower(inputJsonArray);
        repo.getByTags(tags).forEach((Block<Document>) (value) -> {
            result.put(value);
        });
        return result;
    }

    @Override
    public void updateStatus() {
        Thread thread = new Thread(() -> {
            repo.getAll().forEach((Block<Document>) document -> {
                LOGGER.info("Going to update document ");
                String url = document.getString("url");
                String presentStatusinDB = document.getString("status");

                boolean isUp = ginieHttpClient.isUrlUp(url, null);
                String statusfromUrl = getStatus(isUp);
                ObjectId id = (ObjectId) document.get("_id");

                if (!presentStatusinDB.equals(isUp)) {
                    repo.updateStatus(id, statusfromUrl);
                    LOGGER.info("Updated document status {} ", document);
                }
            });
        });
        thread.start();
    }


    @Override
    public List<String> getUrlByenabledandTag(String tag) throws GinieException {

        final List<String> resultList = new ArrayList<>();
        repo.getActiveByTag(tag).forEach(new Block<Document>() {
            @Override
            public void apply(Document document) {
                resultList.add(document.getString("methodUrl"));
            }
        });

        return resultList;
    }

    private String getStatus(boolean value) {
        return value ? "active" : "inactive";
    }
}
