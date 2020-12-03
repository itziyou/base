package com.cpiaoju.base.server.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpiaoju.base.common.entity.system.UserRole;

/**
 * @author ziyou
 */
public interface IUserRoleService  extends IService<UserRole> {

    void deleteUserRolesByRoleId(String[] roleIds);

    void deleteUserRolesByUserId(String[] userIds);
}
