package com.cpiaoju.base.common.handler;

import com.cpiaoju.base.common.entity.BaseResponse;
import com.cpiaoju.base.common.util.BaseUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ziyou
 */
public class BaseAuthExceptionEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        BaseResponse baseResponse = new BaseResponse();
        BaseUtil.makeResponse(
                response, "application/json;charset=UTF-8",
                HttpServletResponse.SC_UNAUTHORIZED, baseResponse.message("token无效")
        );
    }
}
