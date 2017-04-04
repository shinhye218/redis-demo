package test.ruxing.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ruxing.demo.core.config.MyConfig;
import ruxing.demo.entity.po.User;
import ruxing.demo.service.UserService;

/**
 * Created by ruxing on 30/03/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyConfig.class})
public class AnnotationTest {

    @Autowired
    UserService userService;

    @Test
    public void test() {
        User user = userService.findUserById(4L);
        System.out.println("user_id: " + user.getUserId());
        System.out.println("user_name: " + user.getName());
    }

}
