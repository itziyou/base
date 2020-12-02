package com.cpiaoju.base.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpiaoju.base.common.entity.system.Menu;

import java.util.List;

/**
 * @author ziyou
 */
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 用于通过用户名查找用户权限集合
     *
     * @param username 用户名
     * @return 用户权限集合
     */
    List<Menu> findUserPermissions(String username);

}
