package com.cpiaoju.base.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Date;

/**
 * @author ziyou
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseAuthUser extends User {

    private static final long serialVersionUID = -8925304343574025710L;

    private Long userId;

    private String avatar;

    private String email;

    private String mobile;

    private String gender;

    private Long deptId;

    private String deptName;

    private String roleId;

    private String roleName;

    private Date lastLoginTime;

    private String description;

    private String status;

    public BaseAuthUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public BaseAuthUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

}
