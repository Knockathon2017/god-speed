package ginie.httpclient;

import com.google.inject.Inject;
import ginie.GinieException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.impl.client.CloseableHttpClient;

import javax.ws.rs.core.Response;
import java.net.NoRouteToHostException;
import java.util.Map;

/**
 * Created by dhruvr on 6/8/16.
 */
public class GinieHttpClientImpl implements GinieHttpClient {

    private final CloseableHttpClient httpClient;

    @Inject
    public GinieHttpClientImpl(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
    }


    @Override
    public boolean isUrlUp(String url, Map<String, String> headerMap) throws GinieException {
        try {

            HttpGet httGet = new HttpGet(url);

            if (headerMap != null) {
                for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                    httGet.setHeader(entry.getKey(), entry.getValue());
                }
            }

            HttpResponse response = httpClient.execute(httGet);
            if (response.getStatusLine().getStatusCode() == Response.Status.OK.getStatusCode()) {
                return true;
            } else {
                return false;
            }

        } catch (HttpHostConnectException | NoRouteToHostException e) {
            return false;
        }catch (Exception e){
            throw new GinieException("Problem while sending httpRequest ", e);
        }
    }
}
