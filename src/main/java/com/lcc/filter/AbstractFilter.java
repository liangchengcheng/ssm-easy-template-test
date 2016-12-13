package com.lcc.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by lcc on 2016/12/13.
 */
public abstract class AbstractFilter implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rsp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        String method = req.getMethod();

        String requestUri = req.getRequestURI();
        String contextPath = req.getContextPath();
        String url = requestUri.substring(contextPath.length());
        doFilter(req, rsp, chain, session, method, url);
    }

    public abstract void doFilter(HttpServletRequest request,
                                  HttpServletResponse response, FilterChain chain,
                                  HttpSession session, String menthod, String url)
            throws IOException, ServletException;
}
