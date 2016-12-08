package ruxing.redis.mapper;

import org.apache.ibatis.annotations.Param;
import ruxing.redis.entity.po.User;

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
     * 保持用户
     *
     * @param user
     * @return
     */
    Integer saveUser(@Param("user") User user);

}
