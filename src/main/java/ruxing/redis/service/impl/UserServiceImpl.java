package ruxing.redis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ruxing.redis.entity.po.User;
import ruxing.redis.mapper.UserMapper;
import ruxing.redis.service.UserService;

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

    public Integer addUser(User user) {
        if (user == null) {
            return 0;
        }
        return userMapper.saveUser(user);
    }

}
