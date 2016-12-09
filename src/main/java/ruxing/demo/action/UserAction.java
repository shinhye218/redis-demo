package ruxing.demo.action;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ruxing.demo.entity.po.User;
import ruxing.demo.service.UserService;

/**
 * Created by ruxing on 07/12/2016.
 */
@Slf4j
@Controller
@RequestMapping("/user")
public class UserAction {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/findUser")
    public Object findUser() {

        User user = userService.findUserById(1l);
        userService.findUserById(1l);
        userService.findUserByIdWithCache(1l);
        return user;
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
