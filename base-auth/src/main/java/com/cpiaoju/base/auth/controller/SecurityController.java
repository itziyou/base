package com.cpiaoju.base.auth.controller;

import cn.hutool.core.util.StrUtil;
import com.cpiaoju.base.common.entity.BaseResponse;
import com.cpiaoju.base.common.exception.BaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
public class SecurityController {

    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @GetMapping("oauth/test")
    public String testOauth() {
        return "oauth";
    }

    @GetMapping("user")
    public Principal currentUser(Principal principal) {
        return principal;
    }

    @DeleteMapping("signout")
    public BaseResponse signout(HttpServletRequest request) throws BaseAuthException {
        String authorization = request.getHeader("Authorization");
        String token = StrUtil.replace(authorization, "bearer ", "");
        BaseResponse baseResponse = new BaseResponse();
        if (!consumerTokenServices.revokeToken(token)) {
            throw new BaseAuthException("退出登录失败");
        }
        return baseResponse.message("退出登录成功");
    }
}
