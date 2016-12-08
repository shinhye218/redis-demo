package test.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by ruxing on 07/12/2016.
 */
@ContextConfiguration(locations = { "classpath*:/test/spring.xml"})
public class RedisTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private JedisPool jedisPool;

    @Test
    public void testJedisPool() {
        Jedis jedis = jedisPool.getResource();
        jedis.set("fruit", "apple");
        System.out.println(jedis.get("fruit"));
    }

}
