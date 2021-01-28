package org.zzrc.common;

import org.zzrc.util.httpUtil.HttpHeader;

public class HttpHeaderUtil {
    static HttpHeader httpHeader = new HttpHeader();

    public static HttpHeader generateBizHttpHeader(String type, String urlPath, String postBody) {
        httpHeader.addParam("c", "1");
        httpHeader.addParam("ch", "1");
        httpHeader.addParam("b", "0");
        return httpHeader;
    }
    public static HttpHeader generateNoBizHttpHeader() {
        return httpHeader;
    }
    public static HttpHeader generateAKSKHttpHeader(String type, String urlPath, String postBody) {
        httpHeader.addParam("X-ZZRCAuth-Token", AKSKUtil.generateToken(type, urlPath, postBody));
        httpHeader.addParam("c", "1");
        httpHeader.addParam("ch", "1");
        httpHeader.addParam("b", "0");
        return httpHeader;
    }
    public static HttpHeader generateUtcHttpHeader(String u, String t, String userGid, String token) {
        httpHeader.addParam("u", u);
        httpHeader.addParam("t", t);
        httpHeader.addParam("userGid", userGid);
        httpHeader.addParam("token", token);
        httpHeader.addParam("c", "1");
        httpHeader.addParam("ch", "1");
        httpHeader.addParam("b", "0");
        return httpHeader;
    }

}
