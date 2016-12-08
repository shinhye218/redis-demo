package ruxing.redis.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ruxing.redis.entity.po.User;
import ruxing.redis.service.UserService;

/**
 * Created by ruxing on 07/12/2016.
 */
@Controller
@RequestMapping("/user")
public class UserAction {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/findUser", method = RequestMethod.GET)
    public String findUser() {

        User user = userService.findUserById(1l);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser() {
        User user = new User();
        user.setName("yuka");
        user.setAge(32l);
        user.setCity("kyoto");

        userService.addUser(user);
        return "success";
    }

}
