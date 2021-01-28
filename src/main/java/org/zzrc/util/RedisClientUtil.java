package org.zzrc.util;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class RedisClientUtil {
    public static JedisCluster cluster;
    static  {
        Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("192.168.15.26", 6379));
        nodes.add(new HostAndPort("192.168.15.26", 6380));
        nodes.add(new HostAndPort("192.168.15.27", 6379));
        nodes.add(new HostAndPort("192.168.15.27", 6380));
        nodes.add(new HostAndPort("192.168.15.28", 6379));
        nodes.add(new HostAndPort("192.168.15.28", 6380));
        cluster = new JedisCluster(nodes);
    }
    public static void destroyRedis() throws IOException {
        if(cluster != null){
            cluster.close();
        }
    }

    public static void main(String[] args) throws IOException {
//        setRedis("peony:cache:notice:sms_user_abcd", "1234");
        System.out.println(getRedis("peony:cache:notice:sms_user_a4e9bb1fd71c2b0c011f1cf1d921e4b8"));
    }

    public static void setRedis(String key, String value) throws IOException {
        cluster.set(key, value);
        destroyRedis();
    }

    public static String getRedis(String key) throws IOException {
        String value = cluster.get(key);
        destroyRedis();
        return value;
    }
    public static void delRedis(String key) throws IOException {
        if (cluster.exists(key)) {
            if (cluster.del(key) == 1) {
                System.out.println("删除key成功");
            } else {
                System.out.println("删除key失败");
            }
        }
        destroyRedis();
    }
}
