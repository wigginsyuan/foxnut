package org.zzrc.common;

import org.apache.commons.codec.digest.DigestUtils;
import org.zzrc.conf.Constant;

/**
 * PS: aksk工具类
 * author: wiggins
 */
public class AKSKUtil {
    public final static String EXPIRE = "1936422139"; //2031年
    public static String AK = "";
    public static String SK = "";

    public static void chooseAKSK(String type) {
        switch (type) {
            case "mars":
                AK = Constant.MARS_AK;
                SK = Constant.MARS_SK;
                break;
            case "pro":
                AK = Constant.PRO_AK;
                SK = Constant.PRO_SK;
                break;
            case "inner":
                AK = Constant.INNER_AK;
                SK = Constant.INNER_SK;
                break;
        }
    }

    public static String generateToken(String type, String urlPath, String postBody) {
        //PARAM = '|v1-%s-%s|%s|%s|POST||%s|' % (AK, expire_time, SK, URL, body)
        chooseAKSK(type);
        //1.拼接PARAM
        String param = String.join("|", "|v1-" + AK + "-" + EXPIRE, SK, urlPath, "POST", "", postBody + "|");
        //2.生成md5
        String signature = md5(param);
        return String.join("-", "v1", AK, EXPIRE, signature);
    }


    public static String md5(String param) {
        //加密后的字符串
        String encodeStr = DigestUtils.md5Hex(param);
        return encodeStr;
    }
}
