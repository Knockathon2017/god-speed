package ginie.mongo.service;

import ginie.GinieException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by dhruvr on 5/8/16.
 */
public interface MongoServices {

    void insertMicroInfo(JSONObject json) throws GinieException;

    JSONArray listAllMicrosInfo() throws GinieException;

    JSONArray getMicroByTag(JSONObject jsonObject) throws GinieException;

    void updateStatus() throws GinieException;

    List<String> getUrlByenabledandTag(String tag) throws GinieException;
}
