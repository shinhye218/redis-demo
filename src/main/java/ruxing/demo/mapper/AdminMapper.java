package ruxing.demo.mapper;

import org.apache.ibatis.annotations.Param;
import ruxing.demo.entity.po.Admin;

/**
 * Created by ruxing on 17/12/2016.
 */
public interface AdminMapper {

    /**
     * 通过登录名获取登录用户信息
     *
     * @param loginName
     * @return
     */
    Admin findAdminByLoginName(@Param("loginName") String loginName);

}
