package com.cpiaoju.base.auth.service;

import com.cpiaoju.base.auth.manager.UserManager;
import com.cpiaoju.base.common.entity.BaseAuthUser;
import com.cpiaoju.base.common.entity.system.SystemUser;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author ziyou
 */
@Service
@RequiredArgsConstructor
public class BaseUserDetailService implements UserDetailsService {

    private final UserManager userManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SystemUser systemUser = userManager.findByName(username);
        if (systemUser != null) {
            String permissions = userManager.findUserPermissions(systemUser.getUsername());
            boolean notLocked = false;
            if (StringUtils.equals(SystemUser.STATUS_VALID, systemUser.getStatus())) {
                notLocked = true;
            }
            BaseAuthUser authUser = new BaseAuthUser(systemUser.getUsername(), systemUser.getPassword(),
                    true, true, true, notLocked,
                    AuthorityUtils.commaSeparatedStringToAuthorityList(permissions));

            BeanUtils.copyProperties(systemUser, authUser);
            return authUser;
        } else {
            throw new UsernameNotFoundException("");
        }
    }

}
