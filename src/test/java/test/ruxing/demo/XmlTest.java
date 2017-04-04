package test.ruxing.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import ruxing.demo.service.UserService;

/**
 * Created by ruxing on 07/12/2016.
 *
 * since spring.xml has scanned MyWebAppConfig annotated with @EnableWebMvc, WebAppConfiguration is necessary
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/test/spring.xml"})
@WebAppConfiguration
public class XmlTest{

    @Autowired
    private JedisPool jedisPool;

    @Autowired
    UserService userService;


    @Test
    public void testJedisPool() {
        Jedis jedis = jedisPool.getResource();
        jedis.set("fruit", "apple");
        System.out.println(jedis.get("fruit"));
    }

    @Test
    public void test() {
    }

}
