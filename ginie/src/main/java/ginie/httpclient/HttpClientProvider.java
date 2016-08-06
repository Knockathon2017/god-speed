package ginie.httpclient;

import com.google.inject.Inject;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.inject.Provider;

/**
 * Created by dhruvr on 6/8/16.
 */
public class HttpClientProvider implements Provider<CloseableHttpClient> {

    private static CloseableHttpClient httpClient;

    @Inject
    public HttpClientProvider() {
        if (httpClient == null) {
            httpClient = HttpClientBuilder.create().
//                setRedirectStrategy(customRedirectStratergy).
//                setDefaultRequestConfig(globalConfig).
//                setDefaultCookieStore(cookieStore).
        build();
        }
    }

    @Override
    public CloseableHttpClient get() {
        return httpClient;
    }

}
