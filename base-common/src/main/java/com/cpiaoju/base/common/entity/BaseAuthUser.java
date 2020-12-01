package com.cpiaoju.base.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ziyou
 */
@Data
public class BaseAuthUser implements Serializable {

    private static final long serialVersionUID = -8925304343574025710L;

    private String username;

    private String password;

    private boolean accountNonExpired = true;

    private boolean accountNonLocked= true;

    private boolean credentialsNonExpired= true;

    private boolean enabled= true;
}
