package reides.test;

import redis.clients.jedis.Jedis;

/**
 * Created with IntelliJ IDEA.
 * User: �º���.
 * Date: 2017/3/4.
 * Time: ���� 12:28.
 * Explain:����RedisPool
 */
public class RedisJava {

    public static void main(String[] args) {
        RedisPool.getJedis().set("name","�º���");
        System.out.println(RedisPool.getJedis().get("name"));
    }

}

