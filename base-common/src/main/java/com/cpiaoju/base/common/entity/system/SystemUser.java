package com.cpiaoju.base.common.entity.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ziyou
 */
@Data
@TableName("t_user")
public class SystemUser implements Serializable {

    private static final long serialVersionUID = 6351694103767279907L;

    /**
     * 用户状态：有效
     */
    public static final String STATUS_VALID = "1";
    /**
     * 用户状态：锁定
     */
    public static final String STATUS_LOCK = "0";
    /**
     * 默认头像
     */
    public static final String DEFAULT_AVATAR = "default.jpg";
    /**
     * 默认密码
     */
    public static final String DEFAULT_PASSWORD = "1234qwer";
    /**
     * 性别男
     */
    public static final String GENDER_MALE = "0";
    /**
     * 性别女
     */
    public static final String GENDER_FEMALE = "1";
    /**
     * 性别保密
     */
    public static final String GENDER_UNKNOW = "2";

    /**
     * 用户 ID
     */
    @TableId(type = IdType.AUTO)
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 部门 ID
     */
    private Long deptId;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 联系电话
     */
    private String mobile;

    /**
     * 状态 0锁定 1有效
     */
    private String status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 最近访问时间
     */
    private Date lastLoginTime;

    /**
     * 性别 0男 1女 2 保密
     */
    private String gender;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 描述
     */
    private String description;

    /**
     * 部门名称
     */
    @TableField(exist = false)
    private String deptName;

    @TableField(exist = false)
    private String createTimeFrom;

    @TableField(exist = false)
    private String createTimeTo;
    /**
     * 角色 ID
     */
    @TableField(exist = false)
    private String roleId;

    @TableField(exist = false)
    private String roleName;


}
