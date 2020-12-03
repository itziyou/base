package com.cpiaoju.base.common.interceptor;

import com.cpiaoju.base.common.constant.BaseConstant;
import com.cpiaoju.base.common.entity.BaseResponse;
import com.cpiaoju.base.common.util.BaseUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.Base64Utils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ziyou
 */
public class BaseServerProtectInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        // 从请求头中获取 Zuul Token
        String token = request.getHeader(BaseConstant.ZUUL_TOKEN_HEADER);
        String zuulToken = new String(Base64Utils.encode(BaseConstant.ZUUL_TOKEN_VALUE.getBytes()));
        // 校验 Zuul Token的正确性
        if (StringUtils.equals(zuulToken, token)) {
            return true;
        } else {
            BaseResponse baseResponse = new BaseResponse();
            BaseUtil.makeResponse(
                    response, "application/json;charset=UTF-8",
                    HttpServletResponse.SC_FORBIDDEN, baseResponse.message("请通过网关获取资源"));
            return false;
        }
    }
}
