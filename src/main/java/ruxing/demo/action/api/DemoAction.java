package ruxing.demo.action.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ruxing.demo.entity.po.User;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruxing on 04/01/2017.
 */
@Controller
public class DemoAction {

    @RequestMapping("/all/main")
    public void httpTest(HttpServletRequest request) {
        User user = new User();
        user.setName("BoA");
        user.setAge(20l);
    }

    @ResponseBody
    @RequestMapping("/all/backup")
    public Object httpTestBU(HttpServletRequest request) {
        User user = new User();
        user.setName("BoA");
        user.setAge(20l);

        return user;
    }

    public static void main(String[] args) {
        List<String> test = new ArrayList<String>();
        test.add("32");
        test.add("32");
        test.add("32");
        System.out.println("=");
    }

}
