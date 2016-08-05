package ginie.rest;

import com.google.inject.Inject;
import com.sun.deploy.util.StringUtils;
import com.sun.jersey.api.client.ClientResponse;
import ginie.common.JsonUtils;
import ginie.common.NullUtils;
import ginie.enums.Result;
import ginie.settings.GinieSettings;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.apache.commons.lang3.StringUtils.*;

/**
 * Created by dhruvr
 */
public class SecurityFilter implements Filter {


    private GinieSettings settings;

    @Inject
    public SecurityFilter(GinieSettings ginieSettings) {
        this.settings = ginieSettings;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


//        if (request instanceof HttpServletRequest) {
        String url = ((HttpServletRequest) request).getRequestURL().toString();
//        String queryString = ((HttpServletRequest) request).getQueryString();
//        }

        String idStr = url.replaceFirst(".*/([^/?]+).*", "$1");

        if (idStr.equals("login")) {
            chain.doFilter(request, response);
        } else {
            String passcode = ((HttpServletRequest) request).getHeader("Authorization");
            if (!isBlank(passcode) && passcode.equals(settings.get("security.token"))) {
                chain.doFilter(request, response);
            } else {
                ((HttpServletResponse) response).sendError(ClientResponse.Status.UNAUTHORIZED.getStatusCode());
            }
        }


    }

    @Override
    public void destroy() {

    }
}
