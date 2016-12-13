package com.lcc.utils;

import org.springframework.web.util.UriTemplate;

import java.net.URI;

/**
 * Created by lcc on 2016/12/13.
 */
public class URIUtils {
    public static URI createURI(String url, Object... uriVariableValues) {
        return new UriTemplate(url).expand(uriVariableValues);
    }
}
