package reides.test;

import redis.clients.jedis.Jedis;

/**
 * Created with IntelliJ IDEA.
 * User: ³ÂºÆÏè.
 * Date: 2017/3/4.
 * Time: ÏÂÎç 12:28.
 * Explain:²âÊÔRedisPool
 */
public class RedisJava {

    public static void main(String[] args) {
        RedisPool.getJedis().set("name","³ÂºÆÏè");
        System.out.println(RedisPool.getJedis().get("name"));
    }

}

