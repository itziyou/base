package com.cpiaoju.base.auth.properties;

import lombok.Data;

/**
 * @author ziyou
 */
@Data
public class BaseClientsProperties {

    private String client;
    private String secret;
    private String grantType = "password,authorization_code,refresh_token";
    private String scope = "all";

}
