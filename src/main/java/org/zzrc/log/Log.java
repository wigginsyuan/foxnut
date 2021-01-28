package org.zzrc.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * PS:日志类
 * @author wiggins
 *
 */
public class Log {

    private static Logger Log = LogManager.getLogger(Log.class.getName());
    /**
     * 用例开始日志
     */
    public static void startTestCase() {
    	String classname = new Exception().getStackTrace()[1].getClassName();
        Log.info(" --------用例" +classname + "开始执行 --------");
    }
    /**
     * 用例结束日志
     */
    public static void endTestCase() {
    	String classname = new Exception().getStackTrace()[1].getClassName();
        Log.info(" --------用例" +classname + "执行结束 --------");
    }
    /**
     * 根据内容输出日志
     * @param message
     */
    public static void info(String message) {
        Log.info(message);
    }

    public static void warn(String message) {
        Log.warn(message);
    }

    public static void error(String message) {
        Log.error(message);
    }

    public static void fatal(String message) {
        Log.fatal(message);
    }

    public static void debug(String message) {
        Log.debug(message);
    }

}
