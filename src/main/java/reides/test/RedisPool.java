package reides.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created with IntelliJ IDEA.
 * User: �º���.
 * Date: 2017/3/4.
 * Time: ���� 10:14.
 * Explain:Redis���ӳ�
 */
public final class RedisPool {
    //Redis������IP
    private static String ADDR = "127.0.0.1";
    //Redis�Ķ˿ں�
    private static Integer PORT = 6379;
    //��������
    //private static String AUTH = "chenhaoxiang";

    //��������ʵ���������Ŀ��Ĭ��Ϊ8��
    //�����ֵΪ-1�����ʾ�����ƣ����pool�Ѿ�������maxActive��jedisʵ�������ʱpool��״̬Ϊexhausted(�ľ�)
    private static Integer MAX_TOTAL = 1024;
    //����һ��pool����ж��ٸ�״̬Ϊidle(����)��jedisʵ����Ĭ��ֵ��8
    private static Integer MAX_IDLE = 200;
    //�ȴ��������ӵ����ʱ�䣬��λ�Ǻ��룬Ĭ��ֵΪ-1����ʾ������ʱ��
    //��������ȴ�ʱ�䣬��ֱ���׳�JedisConnectionException
    private static Integer MAX_WAIT_MILLIS = 10000;
    private static Integer TIMEOUT = 10000;
    //��borrow(��)һ��jedisʵ��ʱ���Ƿ���ǰ����validate(��֤)������
    //���Ϊtrue����õ���jedisʵ�����ǿ��õ�
    private static Boolean TEST_ON_BORROW = true;
    private  static JedisPool jedisPool = null;

    /**
     * ��̬�飬��ʼ��Redis���ӳ�
     */
    static {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
        /*ע�⣺
            �ڸ߰汾��jedis jar�������籾�汾2.9.0��JedisPoolConfigû��setMaxActive��setMaxWait������
            ������Ϊ�߰汾�йٷ������˴˷��������������������滻��
            maxActive  ==>  maxTotal
            maxWait==>  maxWaitMillis
         */
            config.setMaxTotal(MAX_TOTAL);
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWaitMillis(MAX_WAIT_MILLIS);
            config.setTestOnBorrow(TEST_ON_BORROW);
            //jedisPool = new JedisPool(config,ADDR,PORT,TIMEOUT,AUTH);
            jedisPool = new JedisPool(config,ADDR,PORT,TIMEOUT);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * ��ȡJedisʵ��
     * @return
     */
    public synchronized static Jedis getJedis(){
        try {
            if(jedisPool != null){
                Jedis jedis = jedisPool.getResource();
                return jedis;
            }else{
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void returnResource(final Jedis jedis){
        //��������������Ϊfinal����ʾ����ֻ���ġ�
        if(jedis!=null){
            jedisPool.returnResource(jedis);
            //jedis.close()ȡ��jedisPool.returnResource(jedis)������3.0�汾��ʼ
            //jedis.close();
        }
    }
}
