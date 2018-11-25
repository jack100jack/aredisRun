package reides.test;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: �º���.
 * Date: 2017/3/4.
 * Time: ���� 1:21.
 * Explain:Java����Redis����
 */
public class TestRedis {

    private Jedis jedis;

    @Before
    public void setJedis() {
        //����redis������(�����������ӱ��ص�)
        jedis = new Jedis("127.0.0.1", 6379);
        //Ȩ����֤
        //jedis.auth("chenhaoxiang");
        System.out.println("���ӷ���ɹ�");
    }

    /**
     * Redis�����ַ���
     */
    @Test
    public void testString() {
        //�������
        jedis.set("name", "chx"); //keyΪname����valueֵΪchx
        System.out.println("ƴ��ǰ:" + jedis.get("name"));//��ȡkeyΪname��ֵ

        //��keyΪname��ֵ����������� ---ƴ��
        jedis.append("name", " is my name;");
        System.out.println("ƴ�Ӻ�:" + jedis.get("name"));

        //ɾ��ĳ����ֵ��
        jedis.del("name");
        System.out.println("ɾ����:" + jedis.get("name"));

        //s���ö����ֵ��
        jedis.mset("name", "chenhaoxiang", "age", "20", "email", "chxpostbox@outlook.com");
        jedis.incr("age");//���ڽ���������ֵ����1������������ڣ�����ִ�в���֮ǰ��������Ϊ0�� ����������������͵�ֵ������޷���ʾΪ�������ַ�������᷵�ش��󡣴˲�������64λ�з���������
        System.out.println(jedis.get("name") + " " + jedis.get("age") + " " + jedis.get("email"));
    }

    @Test
    public void testMap() {
        //�������
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "chx");
        map.put("age", "100");
        map.put("email", "***@outlook.com");
        jedis.hmset("user", map);
        //ȡ��user�е�name�������һ�����͵�List
        //��һ�������Ǵ���redis��map�����key����������Ƿ���map�еĶ����key�������key�ǿɱ����
        List<String> list = jedis.hmget("user", "name", "age", "email");
        System.out.println(list);

        //ɾ��map�е�ĳ����ֵ
        jedis.hdel("user", "age");
        System.out.println("age:" + jedis.hmget("user", "age")); //��Ϊɾ���ˣ����Է��ص���null
        System.out.println("user�ļ��д�ŵ�ֵ�ĸ���:" + jedis.hlen("user")); //����keyΪuser�ļ��д�ŵ�ֵ�ĸ���2
        System.out.println("�Ƿ����keyΪuser�ļ�¼:" + jedis.exists("user"));//�Ƿ����keyΪuser�ļ�¼ ����true
        System.out.println("user�����е�����key:" + jedis.hkeys("user"));//����user�����е�����key
        System.out.println("user�����е�����value:" + jedis.hvals("user"));//����map�����е�����value

        //�õ�key����ͨ���������õ�ֵ
        Iterator<String> iterator = jedis.hkeys("user").iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key + ":" + jedis.hmget("user", key));
        }
        jedis.del("user");
        System.out.println("ɾ�����Ƿ����keyΪuser�ļ�¼:" + jedis.exists("user"));//�Ƿ����keyΪuser�ļ�¼

    }

    /**
     * jedis����List
     */
    @Test
    public void testList(){
        //�Ƴ�javaFramwork����������
        jedis.del("javaFramwork");
        //�������
        jedis.lpush("javaFramework","spring");
        jedis.lpush("javaFramework","springMVC");
        jedis.lpush("javaFramework","mybatis");
        //ȡ����������,jedis.lrange�ǰ���Χȡ��
        //��һ����key���ڶ�������ʼλ�ã��������ǽ���λ��
        System.out.println("����:"+jedis.llen("javaFramework"));
        //jedis.llen��ȡ���ȣ�-1��ʾȡ������
        System.out.println("javaFramework:"+jedis.lrange("javaFramework",0,-1));

        jedis.del("javaFramework");
        System.out.println("ɾ���󳤶�:"+jedis.llen("javaFramework"));
        System.out.println(jedis.lrange("javaFramework",0,-1));
    }

    /**
     * jedis����Set
     */
    @Test
    public void testSet(){
        //���
        jedis.sadd("user","chenhaoxiang");
        jedis.sadd("user","hu");
        jedis.sadd("user","chen");
        jedis.sadd("user","xiyu");
        jedis.sadd("user","chx");
        jedis.sadd("user","are");
        //�Ƴ�user�����е�Ԫ��are
        jedis.srem("user","are");
        System.out.println("user�е�value:"+jedis.smembers("user"));//��ȡ���м���user��value
        System.out.println("chx�Ƿ���user�е�Ԫ��:"+jedis.sismember("user","chx"));//�ж�chx�Ƿ���user�����е�Ԫ��
        System.out.println("�����е�һ�����Ԫ��:"+jedis.srandmember("user"));//���ؼ����е�һ�����Ԫ��
        System.out.println("user��Ԫ�صĸ���:"+jedis.scard("user"));
    }

    /**
     * ����
     */
    @Test
    public void test(){
        jedis.del("number");//��ɾ�����ݣ��ٽ��в���
        jedis.rpush("number","4");//��һ������ֵ���뵽�б��β��(���ұ�)
        jedis.rpush("number","5");
        jedis.rpush("number","3");

        jedis.lpush("number","9");//��һ������ֵ���뵽�б�ͷ��
        jedis.lpush("number","1");
        jedis.lpush("number","2");
        System.out.println(jedis.lrange("number",0,jedis.llen("number")));
        System.out.println("����:"+jedis.sort("number"));
        System.out.println(jedis.lrange("number",0,-1));//���ı�ԭ��������
        jedis.del("number");//������ɾ������
    }


}
