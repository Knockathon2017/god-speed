package ginie.httpclient;

import com.google.inject.AbstractModule;
import org.apache.http.impl.client.CloseableHttpClient;

/**
 * Created by dhruvr on 6/8/16.
 */
public class HttpClientModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(CloseableHttpClient.class).toProvider(HttpClientProvider.class).asEagerSingleton();
        bind(GinieHttpClient.class).to(GinieHttpClientImpl.class).asEagerSingleton();
    }
}
