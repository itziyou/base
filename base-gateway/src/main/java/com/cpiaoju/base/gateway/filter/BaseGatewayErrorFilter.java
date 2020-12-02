package com.cpiaoju.base.gateway.filter;

import com.cpiaoju.base.common.entity.BaseResponse;
import com.cpiaoju.base.common.util.BaseUtil;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.servlet.http.HttpServletResponse;

/**
 * @author ziyou
 */
@Slf4j
@Component
public class BaseGatewayErrorFilter extends SendErrorFilter {
    @Override
    public Object run() {
        try {
            BaseResponse baseResponse = new BaseResponse();
            RequestContext ctx = RequestContext.getCurrentContext();
            String serviceId = (String) ctx.get(FilterConstants.SERVICE_ID_KEY);

            ExceptionHolder exception = findZuulException(ctx.getThrowable());
            String errorCause = exception.getErrorCause();
            Throwable throwable = exception.getThrowable();
            String message = throwable.getMessage();
            message = StringUtils.isBlank(message) ? errorCause : message;
            baseResponse = resolveExceptionMessage(message, serviceId, baseResponse);

            HttpServletResponse response = ctx.getResponse();
            BaseUtil.makeResponse(
                    response, "application/json;charset=UTF-8",
                    HttpServletResponse.SC_INTERNAL_SERVER_ERROR, baseResponse
            );
            log.error("Zull sendError：{}", baseResponse.getMessage());
        } catch (Exception ex) {
            log.error("Zuul sendError", ex);
            ReflectionUtils.rethrowRuntimeException(ex);
        }
        return null;
    }

    private BaseResponse resolveExceptionMessage(String message, String serviceId, BaseResponse baseResponse) {
        if (StringUtils.containsIgnoreCase(message, "time out")) {
            return baseResponse.message("请求" + serviceId + "服务超时");
        }
        if (StringUtils.containsIgnoreCase(message, "forwarding error")) {
            return baseResponse.message(serviceId + "服务不可用");
        }
        return baseResponse.message("Zuul请求" + serviceId + "服务异常");
    }
}
