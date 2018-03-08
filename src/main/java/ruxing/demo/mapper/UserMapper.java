package ruxing.demo.mapper;

import org.apache.ibatis.annotations.Param;
import ruxing.demo.entity.po.User;

/**
 * Created by ruxing on 08/12/2016.
 */
public interface UserMapper {

    /**
     * 通过Id查询用户
     *
     * @param userId
     * @return
     */
    User findUserById(@Param("userId") Long userId);

    /**
     * 通过Id查询用户(使用二级缓存)
     *
     * @param userId
     * @return
     */
    User findUserByIdWithCache(@Param("userId") Long userId);

    /**
     * 保存用户
     *
     * @param user
     * @return
     */
    Integer saveUser(@Param("user") User user);


    /**
     * 通过用户Id更新用户
     *
     * @param
     * @return
     */
    Integer updateUserTestBanana();

    /**
     * 通过用户Id更新用户
     *
     * @param
     * @return
     */
    Integer updateUserTestApple();

}
