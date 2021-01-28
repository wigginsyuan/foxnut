package org.zzrc;

import org.testng.annotations.Test;
import org.zzrc.util.JDBCUtil;

import java.util.Map;

public class JDBCUtilTest {
    @Test
    public void testPeony(){
        String sql = "select * from record_loan where id = 0";
        Map<String, Object> rs = JDBCUtil.query(sql);
        for (String key : rs.keySet()) {
            System.out.print(key + "：" + rs.get(key) + "\t");
        }
    }

    @Test
    public void testLotus(){
        String sql = "select * from lotus.user_base where id = 80";
        Map<String, Object> rs = JDBCUtil.query(sql);
        for (String key : rs.keySet()) {
            System.out.print(key + "：" + rs.get(key) + "\t");
        }
    }
}
