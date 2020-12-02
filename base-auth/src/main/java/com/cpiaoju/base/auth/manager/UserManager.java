package com.cpiaoju.base.auth.manager;

import com.cpiaoju.base.auth.mapper.MenuMapper;
import com.cpiaoju.base.auth.mapper.UserMapper;
import com.cpiaoju.base.common.entity.system.Menu;
import com.cpiaoju.base.common.entity.system.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ziyou
 */
@Service
public class UserManager {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MenuMapper menuMapper;

    public SystemUser findByName(String username) {
        return userMapper.findByName(username);
    }

    public String findUserPermissions(String username) {
        List<Menu> userPermissions = menuMapper.findUserPermissions(username);
        return userPermissions.stream().map(Menu::getPerms).collect(Collectors.joining(","));
    }
}
