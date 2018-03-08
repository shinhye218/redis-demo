package ruxing.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ruxing.demo.entity.po.Admin;
import ruxing.demo.mapper.AdminMapper;
import ruxing.demo.service.AdminService;
import ruxing.demo.service.UserService;

/**
 * Created by ruxing on 17/12/2016.
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private UserService userService;

    public Admin findAdminByLoginName(String loginName) {
        if (loginName == null) {
            return null;
        }
        return adminMapper.findAdminByLoginName(loginName);
    }

    @Transactional
    public void updateUserTestBanana() {
//        userMapper.updateUserTestBanana();
//        throw new RuntimeException("transactional test");
        try {
            userService.updateUserTestApple();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }

}
