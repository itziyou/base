package com.cpiaoju.base.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpiaoju.base.common.entity.system.SystemUser;

/**
 * @author ziyou
 */
public interface UserMapper extends BaseMapper<SystemUser> {

    /**
     * 用于通过用户名查找用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    SystemUser findByName(String username);

}
