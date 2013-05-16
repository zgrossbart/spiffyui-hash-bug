package com.github.mbsimonovic.spiffy.server;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <code>localhost/index.html#!contact</code> and <code>localhost/#!contact</code>
 * are the same page. This filter redirects all requests from the former URL to the latter.
 */
public class HostPageFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (!(request instanceof HttpServletRequest)) {
            chain.doFilter(request, response);
            return;
        }

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if (req.getRequestURI().contains("index.html")) {
            String newUrl = req.getRequestURL().toString().replace("index.html", "");
            if (req.getQueryString() != null) {
                newUrl += "?" + req.getQueryString();
            }
            res.setHeader("Location", newUrl);
            res.sendError(HttpServletResponse.SC_MOVED_PERMANENTLY);
            // return;
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

    @Override
    public void destroy() {
    }

}
