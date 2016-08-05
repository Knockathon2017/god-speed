package ginie.mongo.service;

import ginie.GinieException;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by dhruvr on 5/8/16.
 */
public interface MongoServices {

    void insertMicroInfo(JSONObject json) throws GinieException;

    JSONArray listAllMicrosInfo() throws GinieException;

    JSONArray getMicroByTag(JSONObject jsonObject) throws GinieException;

}
