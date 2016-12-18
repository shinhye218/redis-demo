package ruxing.demo.core.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import ruxing.demo.entity.po.Admin;
import ruxing.demo.service.AdminService;

/**
 * Created by ruxing on 12/12/2016.
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private AdminService adminService;

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        Admin admin = adminService.findAdminByLoginName((String) token.getPrincipal());
        if (admin == null) {
            return null;
        }
        return new SimpleAuthenticationInfo(admin, admin.getPassword(), getName());
    }

}
