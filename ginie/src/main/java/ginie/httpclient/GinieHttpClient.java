package ginie.httpclient;

import ginie.GinieException;

import java.util.Map;

/**
 * Created by dhruvr on 6/8/16.
 */
public interface GinieHttpClient {

    boolean isUrlUp(String url, Map<String, String> headerMap) throws GinieException;

}
