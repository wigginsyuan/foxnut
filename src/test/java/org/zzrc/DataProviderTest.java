package org.zzrc;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
    @DataProvider
    public Object[][] dataProvider(){
        return new Object[][]{
                {"小李"},
                {"小赵"},
                {"小明"},
                {"小周"}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void testcase(String name){
        System.out.println(name);
    }
}
