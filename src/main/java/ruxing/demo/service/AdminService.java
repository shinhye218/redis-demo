package ruxing.demo.service;

import ruxing.demo.entity.po.Admin;

/**
 * Created by ruxing on 17/12/2016.
 */
public interface AdminService {

    /**
     * 通过登录名获取登录用户信息
     *
     * @param loginName
     * @return
     */
    Admin findAdminByLoginName(String loginName);

    void updateUserTestBanana();

}
