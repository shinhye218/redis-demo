package ruxing.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ruxing.demo.entity.po.User;
import ruxing.demo.mapper.UserMapper;
import ruxing.demo.service.UserService;

/**
 * Created by ruxing on 08/12/2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User findUserById(Long userId) {
        return userMapper.findUserById(userId);
    }

    public User findUserByIdWithCache(Long userId) {
        return userMapper.findUserByIdWithCache(userId);
    }

    public Integer addUser(User user) {
        if (user == null) {
            return 0;
        }
        return userMapper.saveUser(user);
    }

    @Transactional
    public void updateUserTestBanana() {
//        userMapper.updateUserTestBanana();
//        throw new RuntimeException("transactional test");
        try {
            updateUserTestApple();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateUserTestApple() {
        userMapper.updateUserTestApple();
        throw new RuntimeException("Apple throw exception");
    }

}
