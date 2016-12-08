package ruxing.redis.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ruxing on 07/12/2016.
 */
@Controller
@RequestMapping("/demo")
public class DemoAction {

    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String flyToTheSky() {
        return "success";
    }

}
