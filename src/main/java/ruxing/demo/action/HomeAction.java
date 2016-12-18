package ruxing.demo.action;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ruxing.demo.entity.vo.request.LoginRequest;

import javax.servlet.ServletRequest;

/**
 * Created by ruxing on 12/12/2016.
 */
@Slf4j
@Controller
public class HomeAction {

    /**
     * 跳到登录页面
     *
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "/login";
    }

    /**
     * 登录表单处理方法
     *
     * @param request
     * @param servletRequest
     * @return
     */
    @RequestMapping("/doLogin")
    public String doLogin(LoginRequest request, ServletRequest servletRequest){
        try {
            Subject currentUser = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(request.getUsername(), request.getPassword());
            currentUser.login(token);
        } catch (Exception e) {
            log.error("登录失败 " + e);
            return "redirect:" + "/error";
        }
        SavedRequest savedRequest = WebUtils.getSavedRequest(servletRequest);
        if (savedRequest == null) {
            return "redirect:" + "/success";
        }
        return "redirect:" + savedRequest.getRequestUrl();
    }

    /**
     * 登录成功(当没有SavedRequest时备用)
     *
     * @return
     */
    @RequestMapping("/success")
    public String success() {
        return "/success";
    }

    /**
     * 登录失败
     *
     * @return
     */
    @RequestMapping("/error")
    public String error() {
        return "/error";
    }

}
