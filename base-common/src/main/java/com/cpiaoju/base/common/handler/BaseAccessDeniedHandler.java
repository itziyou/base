package com.cpiaoju.base.common.handler;

import com.cpiaoju.base.common.entity.BaseResponse;
import com.cpiaoju.base.common.util.BaseUtil;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ziyou
 */
public class BaseAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {

        BaseResponse baseResponse = new BaseResponse();

        BaseUtil.makeResponse(
                response, "application/json;charset=UTF-8",
                HttpServletResponse.SC_FORBIDDEN, baseResponse.message("没有权限访问该资源"));

    }
}
