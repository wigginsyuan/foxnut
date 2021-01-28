package org.zzrc.util;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import org.bson.Document;
import org.bson.conversions.Bson;

/**
 * PS：mongo工具类
 * author：wiggins
 */
public class MongoDbUtil {
    /* 建立连接 */
    public static MongoDatabase setConnection() {
        try {
            //  连接MongoDB服务
            @SuppressWarnings("resource")
            MongoClient mongoClient=new MongoClient("localhost",27017);
            // 连接到数据库
            MongoDatabase mongoDatabase=mongoClient.getDatabase("test");
            System.out.println("successfully connecting"+mongoClient);
            return mongoDatabase;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }
    /* 默认collection */
    public static String userinfoCollection() {
        return "info";
    }
    @SuppressWarnings({ })
    /* 查找JSON */
    public static boolean checkinfo(String user,String password) {
        boolean result=false;
        if(setConnection()!=null) {
            MongoDatabase mongoDatabase=setConnection();
            assert mongoDatabase != null;
            MongoCollection<Document> collection=mongoDatabase.getCollection(userinfoCollection());
            // "userid","userpassword"是我info集合下的字段名
            Bson filter=Filters.eq("userid",user);
            FindIterable<Document> findIterable=collection.find(filter);
            MongoCursor<Document> cursor=findIterable.iterator();
            while(cursor.hasNext()) {
                Bson refilter=Filters.eq("userpasswd",password);
                FindIterable<Document> refindIterable=collection.find(refilter);
                for (Document document : refindIterable) {
                    System.out.println(document);
                    result = true;
                }
            }
        }else {
            // 连接MongeDB失败
            System.out.println("Connection failure");
        }
        return result;
    }
    /* 插入JSON */
    public static boolean insertinfo(String user,String password) {
        if(setConnection()!=null) {
            MongoDatabase mongoDatabase=setConnection();
            // System.out.println(mongoDatabase);
            assert mongoDatabase != null;
            MongoCollection<Document> collection=mongoDatabase.getCollection(userinfoCollection());
            // System.out.println(userinfoCollection());
            Document document=new Document("userid",user).append("userpasswd", password);
            collection.insertOne(document);
            return true;
        }else {
            // 连接MongeDB失败
            System.out.println("Connection failure");
            return false;
        }
    }
    /* 更新JSON */
    public static boolean updateinfo(String user,String newpasswd) {
        if(setConnection()!=null) {
            MongoDatabase mongoDatabase=setConnection();
            assert mongoDatabase != null;
            MongoCollection<Document> collection=mongoDatabase.getCollection(userinfoCollection());
            Bson filter=Filters.eq("userid",user);
            Document document=new Document("$set",new Document("userpasswd",newpasswd));
            collection.updateOne(filter, document);
            return true;
        }else {
            // 连接MongeDB失败
            System.out.println("Connection failure");
            return false;
        }
    }
    // 进行简单测试
    public static void main(String[] args) {
        setConnection();
        boolean rs1=checkinfo("admin", "passwd1");
        System.out.print(rs1);
        boolean rs2=insertinfo("newadmin", "newpasswd");
        System.out.print(rs2);
        boolean rs3=updateinfo("admin", "passwd");
        System.out.print(rs3);
    }
}