package reides.test;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
 
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
public class redistest {

	public static void main(String[] args){
		//连接本地的Redis服务
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		System.out.println("连接成功！");
		//密码验证
		//jedis.auth("123456");
		//查看服务是否运行
		System.out.println("服务是否运行：" + jedis.ping());
	}
	/*
	public static void main(String[] args){
		//连接本地的Redis服务
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		System.out.println("连接成功！");
		//密码验证
		jedis.auth("123456");
		//设置字符串数据
		jedis.set("myKey", "testStr");
		//通过key输出缓存内容
		System.out.println("输出内容为：" + jedis.get("myKey"));
	}
	public static void main(String[] args){
		//连接本地的Redis服务
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		System.out.println("连接成功！");
		//密码验证
		jedis.auth("123456");
		//存储List缓存数据
		jedis.lpush("test-list", "Java");
		jedis.lpush("test-list", "PHP");
		jedis.lpush("test-list", "C++");
		//获取list缓存数据
		List<String> listCache = jedis.lrange("test-list", 0, 3);
		for (int i = 0; i < listCache.size(); i++) {
			System.out.println("缓存输出：" + listCache.get(i));
		}
	}
	public static void main(String[] args){
		//连接本地的Redis服务
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		System.out.println("连接成功！");
		//密码验证
		jedis.auth("123456");
		//存储Hash类型缓存数据
		Map<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("xiaoming", "man");
		hashMap.put("xiaohua", "women");
		hashMap.put("xiaoma", "man");
		jedis.hmset("test-hash", hashMap);
		//获取hash类型缓存数据
		Map<String, String> hashData = jedis.hgetAll("test-hash");
		System.out.println("获取hash缓存数据（xiaoming）："+hashData.get("xiaoming"));
		System.out.println("获取hash缓存数据（xiaohua）："+hashData.get("xiaohua"));
		System.out.println("获取hash缓存数据（xiaoma）："+hashData.get("xiaoma"));
	}
	//Set（无序，不重复集合） 类型实例
	public static void main(String[] args){
		//连接本地的Redis服务
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		System.out.println("连接成功！");
		//密码验证
		jedis.auth("123456");
		//存储Set缓存数据
		jedis.sadd("test-set", "Java");
		jedis.sadd("test-set", "PHP");
		jedis.sadd("test-set", "C++");
		jedis.sadd("test-set", "PHP");
		//获取set缓存数据
		Set<String> setCache = jedis.smembers("test-set");
		for(String setStr : setCache){
			System.out.println("Set集合缓存输出:" + setStr);
		}
	}
	public static void main(String[] args){
		//连接本地的Redis服务
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		System.out.println("连接成功！");
		//密码验证
		jedis.auth("123456");
		//存储zset类型缓存数据
		jedis.zadd("test-zset",1,"Java");
		jedis.zadd("test-zset",3,"C++");
		jedis.zadd("test-zset",2,"PHP");
		jedis.zadd("test-zset",2,"PHP");
		//获取zset缓存数据类型
		Set<String> setCache = jedis.zrange("test-zset", 0, 5);
		for(String setStr : setCache){
			System.out.println("获取zset缓存数据：" + setStr);
		}
	}
*/


}
