package ruxing.demo.service;

import ruxing.demo.entity.po.User;

/**
 * Created by ruxing on 08/12/2016.
 */
public interface UserService {

    /**
     * 通过Id查询用户
     *
     * @param userId
     * @return
     */
    User findUserById(Long userId);

    /**
     * 通过Id查询用户(使用缓存)
     *
     * @param userId
     * @return
     */
    User findUserByIdWithCache(Long userId);

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    Integer addUser(User user);

}
