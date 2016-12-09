package ruxing.demo.entity.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ruxing on 08/12/2016.
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1043088843047983374L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 名字
     */
    private String name;

    /**
     * 年龄
     */
    private Long age;

    /**
     * 城市
     */
    private String city;

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
