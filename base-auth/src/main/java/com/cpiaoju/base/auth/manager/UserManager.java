package com.cpiaoju.base.auth.manager;

import com.cpiaoju.base.auth.mapper.MenuMapper;
import com.cpiaoju.base.auth.mapper.UserMapper;
import com.cpiaoju.base.common.entity.system.Menu;
import com.cpiaoju.base.common.entity.system.SystemUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ziyou
 */
@Service
@RequiredArgsConstructor
public class UserManager {

    private final UserMapper userMapper;
    private final MenuMapper menuMapper;

    public SystemUser findByName(String username) {
        return userMapper.findByName(username);
    }

    public String findUserPermissions(String username) {
        List<Menu> userPermissions = menuMapper.findUserPermissions(username);
        return userPermissions.stream().map(Menu::getPerms).collect(Collectors.joining(","));
    }
}
