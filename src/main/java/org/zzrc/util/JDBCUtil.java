package org.zzrc.util;

import org.zzrc.conf.Constant;
import org.zzrc.log.Log;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * PS:数据库相关操作类
 * @author wiggins
 *
 */
public class JDBCUtil {
	//数据库连接引用
	private static Connection conn = null;
	/**
	 * PS:获取数据库连接
	 */
	static{
		try {
			//注册驱动
			Class.forName(Constant.JDBC_DRIVER);
			//获取连接对象
			conn = DriverManager.getConnection(Constant.DB_URL, Constant.DB_USER, Constant.DB_PWD);
		} catch (ClassNotFoundException e) {
			Log.error("-----注册JDBC驱动失败-----");
		} catch (SQLException e) {
			Log.error("-----获取连接对象失败-----");
		}
	}
	
	/**
	 * PS:根据查询语句和指定字段查询结果
	 * @param querySql 查询语句
	 * @param values 指定字段
	 * @return 查询结果键值对集合
	 */ 
	public static Map<String, Object> query(String querySql,Object ... values) {
		//最终返回的map集合
		Map<String,Object> columnLabelAndValues = new HashMap<String, Object>();
		try {
			//创建执行对象
			PreparedStatement prepareStatement = conn.prepareStatement(querySql);
			//设置条件字段的值
			for(int i=0;i<values.length;i++) {
				prepareStatement.setObject(i+1, values[i]);
			}
			//执行查询语句获取结果集
			ResultSet resultSet = prepareStatement.executeQuery();
			//获取查询相关信息
			ResultSetMetaData resultSetMeteData = resultSet.getMetaData();
			//获取查询字段的数目
			int columnCount = resultSetMeteData.getColumnCount();
			//遍历结果集
			while(resultSet.next()) {
				//遍历结果的各个字段值
				for(int i =1;i<=columnCount;i++) {
					//获取字段标签列名
					String columnLabel = resultSetMeteData.getColumnLabel(i);
					//获取字段值
					Object columnValueObject = resultSet.getObject(columnLabel);
					String columnValue = "";
					if(columnValueObject!=null) {
						columnValue = columnValueObject.toString();
					}
					//塞入map
					columnLabelAndValues.put(columnLabel, columnValue);
				}
			}
		} catch (SQLException e) {
			Log.error("-----执行"+querySql+"查询失败-----");
		}
		return columnLabelAndValues;
	}
	

}
