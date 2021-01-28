package org.zzrc.util.httpUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * PS：请求头
 * author: wiggins
 */
public class HttpHeader {
    private Map<String, String> params = new HashMap<String, String>();

    public HttpHeader addParam(String name, String value) {
        this.params.put(name, value);
        return this;
    }

    public Map<String, String> getParams() {
        return this.params;
    }
}
