package org.zzrc;


import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.zzrc.asserts.assertUtil;
import org.zzrc.common.AKSKUtil;
import org.zzrc.common.BaseCase;
import org.zzrc.common.HttpHeaderUtil;
import org.zzrc.conf.Constant;
import org.zzrc.util.httpUtil.HttpHeader;
import org.zzrc.util.httpUtil.HttpParamers;
import org.zzrc.util.httpUtil.HttpService;

/**
 * PS:http请求测试类
 * @author wiggins
 *
 */
public class HttpUtilTest extends BaseCase {

    //免费的在线REST服务, 提供测试用的HTTP请求假数据
    //接口信息说明可见：http://www.hangge.com/blog/cache/detail_2020.html
    String uri = "http://jsonplaceholder.typicode.com";

    //get方式请求数据
    //请求地址：http://jsonplaceholder.typicode.com/posts
    @Test(enabled = false)
    public void test1() {
        System.out.print("\n" + "test1---------------------------"+ "\n");
        HttpParamers paramers = HttpParamers.httpGetParamers();
        String response = "";
        try {
            HttpService httpService = new HttpService(uri);
            response = httpService.service("/posts", paramers);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.print(response);
    }

    @Test(enabled = false)
    public void test2() {
        System.out.print("\n" + "test2---------------------------"+ "\n");
        HttpParamers paramers = HttpParamers.httpGetParamers();
        paramers.addParam("userId", "5");
        String response = "";
        try {
            HttpService httpService = new HttpService(uri);
            response = httpService.service("/posts", paramers);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.print(response);
    }

    @Parameters({"host"})
    @Test
    public void test3(@Optional(Constant.DEFAULT_HOST)String host) {
        String url = "/aksk/salesman/queryLoanOrderList";
        HttpParamers httpParamers = HttpParamers.httpPostParamers();
        httpParamers.setJsonBody("{\"salesmanGidList\":[\"202004281234\"],\"status\":4,\"currPage\":1,\"pageSize\":10}");
        HttpHeader httpHeader = HttpHeaderUtil.generateAKSKHttpHeader("inner", "/aksk/salesman/queryLoanOrderList","{\"salesmanGidList\":[\"202004281234\"],\"status\":4,\"currPage\":1,\"pageSize\":10}");
        String response = runCase(host, url, httpParamers, httpHeader);
        assertUtil.assertTrue(true);
    }
}