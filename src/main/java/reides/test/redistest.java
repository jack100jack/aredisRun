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
		//���ӱ��ص�Redis����
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		System.out.println("���ӳɹ���");
		//������֤
		//jedis.auth("123456");
		//�鿴�����Ƿ�����
		System.out.println("�����Ƿ����У�" + jedis.ping());
	}
	/*
	public static void main(String[] args){
		//���ӱ��ص�Redis����
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		System.out.println("���ӳɹ���");
		//������֤
		jedis.auth("123456");
		//�����ַ�������
		jedis.set("myKey", "testStr");
		//ͨ��key�����������
		System.out.println("�������Ϊ��" + jedis.get("myKey"));
	}
	public static void main(String[] args){
		//���ӱ��ص�Redis����
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		System.out.println("���ӳɹ���");
		//������֤
		jedis.auth("123456");
		//�洢List��������
		jedis.lpush("test-list", "Java");
		jedis.lpush("test-list", "PHP");
		jedis.lpush("test-list", "C++");
		//��ȡlist��������
		List<String> listCache = jedis.lrange("test-list", 0, 3);
		for (int i = 0; i < listCache.size(); i++) {
			System.out.println("���������" + listCache.get(i));
		}
	}
	public static void main(String[] args){
		//���ӱ��ص�Redis����
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		System.out.println("���ӳɹ���");
		//������֤
		jedis.auth("123456");
		//�洢Hash���ͻ�������
		Map<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("xiaoming", "man");
		hashMap.put("xiaohua", "women");
		hashMap.put("xiaoma", "man");
		jedis.hmset("test-hash", hashMap);
		//��ȡhash���ͻ�������
		Map<String, String> hashData = jedis.hgetAll("test-hash");
		System.out.println("��ȡhash�������ݣ�xiaoming����"+hashData.get("xiaoming"));
		System.out.println("��ȡhash�������ݣ�xiaohua����"+hashData.get("xiaohua"));
		System.out.println("��ȡhash�������ݣ�xiaoma����"+hashData.get("xiaoma"));
	}
	//Set�����򣬲��ظ����ϣ� ����ʵ��
	public static void main(String[] args){
		//���ӱ��ص�Redis����
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		System.out.println("���ӳɹ���");
		//������֤
		jedis.auth("123456");
		//�洢Set��������
		jedis.sadd("test-set", "Java");
		jedis.sadd("test-set", "PHP");
		jedis.sadd("test-set", "C++");
		jedis.sadd("test-set", "PHP");
		//��ȡset��������
		Set<String> setCache = jedis.smembers("test-set");
		for(String setStr : setCache){
			System.out.println("Set���ϻ������:" + setStr);
		}
	}
	public static void main(String[] args){
		//���ӱ��ص�Redis����
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		System.out.println("���ӳɹ���");
		//������֤
		jedis.auth("123456");
		//�洢zset���ͻ�������
		jedis.zadd("test-zset",1,"Java");
		jedis.zadd("test-zset",3,"C++");
		jedis.zadd("test-zset",2,"PHP");
		jedis.zadd("test-zset",2,"PHP");
		//��ȡzset������������
		Set<String> setCache = jedis.zrange("test-zset", 0, 5);
		for(String setStr : setCache){
			System.out.println("��ȡzset�������ݣ�" + setStr);
		}
	}
*/


}
