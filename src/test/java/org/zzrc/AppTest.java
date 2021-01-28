package org.zzrc;

import static org.junit.Assert.assertTrue;

import org.testng.annotations.Test;
import org.zzrc.log.Log;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        Log.startTestCase();
        Log.info("fox项目初始化测试通过");
        assertTrue( true );
        Log.endTestCase();
    }
}
