package ruxing.demo.entity.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ruxing on 17/12/2016.
 */
@Data
public class Admin implements Serializable {

    private static final long serialVersionUID = 4561210483020094559L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 密码
     */
    private String password;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date UpdateTime;

    /**
     * 删除标记(0 未删除 1 删除)
     */
    private Boolean deleted;

}
