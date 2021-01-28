package org.zzrc;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.zzrc.common.AKSKUtil;

public class AKSKUtilTest {
    @Test
    public void testAkSk(){
        String token = AKSKUtil.generateToken("inner", "/aksk/salesman/queryLoanOrderList","{\"salesmanGidList\":[\"202004281234\"],\"status\":4,\"currPage\":1,\"pageSize\":10}");
        System.out.println(token);
        Assert.assertEquals("v1-3ad44685a73e4a329f31-1936422139-95c94085273af07f4a7164fe2cdbe80c", token);
    }
}