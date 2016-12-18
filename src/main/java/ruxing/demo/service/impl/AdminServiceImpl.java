package ruxing.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ruxing.demo.entity.po.Admin;
import ruxing.demo.mapper.AdminMapper;
import ruxing.demo.service.AdminService;

/**
 * Created by ruxing on 17/12/2016.
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    public Admin findAdminByLoginName(String loginName) {
        if (loginName == null) {
            return null;
        }
        return adminMapper.findAdminByLoginName(loginName);
    }

}
