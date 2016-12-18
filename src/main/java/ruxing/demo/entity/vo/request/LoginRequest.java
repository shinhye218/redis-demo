package ruxing.demo.entity.vo.request;

import lombok.Data;

/**
 * Created by ruxing on 12/12/2016.
 */
@Data
public class LoginRequest {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 记住我
     */
    private Boolean rememberMe;

}
