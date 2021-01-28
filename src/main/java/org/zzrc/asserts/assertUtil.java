package org.zzrc.asserts;

import org.testng.Assert;
import org.zzrc.log.Log;

/**
 * PS:断言工具类
 * @author wiggins
 *
 */
public class assertUtil extends Assert {
	/**
	 * PS:是否包含断言信息
	 * @param target：实际结果
	 * @param assertion：预期结果
	 */
	public static boolean check(String target,String assertion){
		boolean flag = target.contains(assertion);
		if(flag) {
			Log.info("-----包含断言通过,检测响应部分包含断言["+assertion+"]-----");
		}else {
			throw new AssertionError("-----包含断言失败,检测响应部分["+target+"]未包含断言["+assertion+"]-----");

		}
		return true;
	}
	/**
	 * PS:是否等于断言信息
	 * @param target：实际结果
	 * @param assertion：预期结果
	 */
	public static void equals(String target,String assertion) {
		boolean flag = assertion.equals(target);
		if(flag) {
			Log.info("-----比较断言通过,检测响应部分等于断言["+assertion+"]-----");
		}else {
			throw new AssertionError("-----比较断言失败,检测响应部分不等于断言["+assertion+"]-----");
		}
	}
	/**
	 * PS:是否匹配正则表达式
	 * @param target：实际结果
	 * @param assertionRegex：预期结果
	 */
	public static void matches(String target,String assertionRegex){
		boolean flag = target.matches(assertionRegex);
		if(flag) {
			Log.info("-----正则匹配断言通过,检测响应部分["+target+"]匹配断言正则表达式["+assertionRegex+"]-----");
		}else {
			throw new AssertionError("-----正则匹配断言未通过,检测响应部分["+target+"]不匹配断言正则表达式["+assertionRegex+"]-----");
		}

	}
	/**
	 * PS:开头匹配断言
	 * @param target：实际结果
	 * @param assertion：预期结果
	 */
	public static void startsWith(String target,String assertion){
		boolean flag = target.startsWith(assertion);
		if(flag) {
			Log.info("-----检测开头断言通过,检测响应部分["+target+"]的头部是断言["+assertion+"]-----");
		}else {
			throw new AssertionError("-----检测开头断言未通过,检测响应部分["+target+"]的头部不是断言["+assertion+"]-----");
		}

	}
	/**
	 * PS:结尾匹配断言
	 * @param target：实际结果
	 * @param assertion：预期结果
	 */
	public static void endsWith(String target,String assertion){
		boolean flag = target.endsWith(assertion);
		if(flag) {
			Log.info("-----检测结尾断言通过,检测响应部分["+target+"]的结尾是断言["+assertion+"]-----");
		}else {
			throw new AssertionError("-----检测结尾断言未通过,检测响应部分["+target+"]的结尾不是断言["+assertion+"]-----");
		}

	}


}
