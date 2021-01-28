package org.zzrc.common;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.zzrc.log.Log;
import org.zzrc.util.httpUtil.HttpHeader;
import org.zzrc.util.httpUtil.HttpParamers;
import org.zzrc.util.httpUtil.HttpService;

public class BaseCase {
    @BeforeSuite
    public void beforeSuite() {
        Log.startTestCase();
    }
    @AfterSuite
    public void afterSuite() {
        Log.endTestCase();
    }

    public String runCase(String host, String url, HttpParamers httpParamers, HttpHeader httpHeader) {
        String response = "";
        try {
            HttpService httpService = new HttpService(host);
            response = httpService.service(url, httpParamers, httpHeader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public String runCase(String host, String url, HttpParamers httpParamers) {
        String response = "";
        try {
            HttpService httpService = new HttpService(host);
            response = httpService.service(url, httpParamers);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
