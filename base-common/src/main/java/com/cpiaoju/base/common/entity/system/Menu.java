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
@TableName("t_menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = -3386646951111910745L;


    /**
     * 菜单
     */
    public static final String TYPE_MENU = "0";
    /**
     * 按钮
     */
    public static final String TYPE_BUTTON = "1";

    /**
     * 菜单/按钮ID
     */
    @TableId(type = IdType.AUTO)
    private Long menuId;

    /**
     * 上级菜单ID
     */
    private Long parentId;

    /**
     * 菜单/按钮名称
     */
    private String menuName;

    /**
     * 菜单URL
     */
    private String path;

    /**
     * 对应 Vue组件
     */
    private String component;

    /**
     * 权限标识
     */
    private String perms;

    /**
     * 图标
     */
    private String icon;

    /**
     * 类型 0菜单 1按钮
     */
    private String type;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    private transient String createTimeFrom;
    private transient String createTimeTo;
}
