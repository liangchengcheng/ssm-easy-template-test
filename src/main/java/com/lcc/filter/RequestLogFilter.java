package com.lcc.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lcc on 2016/12/13.
 */
public class RequestLogFilter extends AbstractFilter {
    private static Logger logger = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger = LoggerFactory.getLogger(RequestLogFilter.class);
    }

    @Override
    public void destroy() {
        logger = null;
    }

    public static String getParamsString(Map<String, String[]> params) {
        if (params == null || params.isEmpty()) {
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        buffer.append("?");

        for (String key : params.keySet()) {
            buffer.append(key).append("=").append(params.get(key)[0])
                    .append("&");
        }

        buffer.deleteCharAt(buffer.lastIndexOf("&"));
        return buffer.toString();
    }

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain, HttpSession session, String menthod, String url) throws IOException, ServletException {
        logger.info("Accept:{}", request.getHeader("Accept"));
        logger.info("Content-Type:{}", request.getHeader("Content-Type"));
        logger.info("------开始过滤--------");

        long before = System.currentTimeMillis();
        logger.info("拦截到请求:{} : {}{}", menthod, url, getParamsString(request.getParameterMap()));

        chain.doFilter(request, response);
        long after = System.currentTimeMillis();
        logger.info("请求结果:" + url + " status:" + response.getStatus());
        logger.info("花费时间：" + (after - before) + "ms");

        logger.info("------过滤结束---------\n");
    }
}
