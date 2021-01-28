package org.zzrc.conf;

/**
 * PS:配置类
 * @author wiggins
 *
 */
public abstract class Constant {
	//接口信息excel文件路径
	public final static String EXCEL_PATH = "src/main/resources/test_api_table.xlsx";

	//接口信息excel可用列数最大下标
	public final static int TOTALCELLNUM = 5;

	//接口信息excel字段提示索引
	public final static int FIELDNUM = 1;
	
	//JDBC驱动名
	public final static String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 

	//数据库地址(连接8.0以上用下面的连接地址)
	public final static String DB_URL = "jdbc:mysql://192.168.15.31:3306/peony?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&useSSL=false";

	//数据库用户名
	public final static String DB_USER = "qa";

	//数据库密码
	public final static String DB_PWD = "pAqk5wPY9L48QMxd";

	//inner channel ak sk
	public final static String INNER_AK = "3ad44685a73e4a329f31";
	public final static String INNER_SK = "5w57c89914724af583ef80de6eb15ddcefab6a48a9188";

	//mars ak sk
	public final static String MARS_AK = "uwd44685a7234a329frq";
	public final static String MARS_SK = "pq57c89914724af583ef812e6eb15ddcefab6a48a9156";

	//pro ak sk  C值是100100
	public final static String PRO_AK = "oXuFouM2MkJHmcbVHJmffXwWkPjZJJwb";
	public final static String PRO_SK = "QVLRZYOAldfyO6FdAaYAxG2ZSCFTkhtD";

	public final static String DEFAULT_HOST = "http://ebjqa.zzrcer.com/peony";
}
