package com.cpiaoju.base.common.selector;

import com.cpiaoju.base.common.configure.BaseAuthExceptionConfigure;
import com.cpiaoju.base.common.configure.BaseOAuth2FeignConfigure;
import com.cpiaoju.base.common.configure.BaseServerProtectConfigure;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author ziyou
 */
public class BaseCloudApplicationSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        // BaseAuthExceptionConfigure 认证类型异常翻译；
        // BaseOAuth2FeignConfigure 开启带令牌的Feign请求，避免微服务内部调用出现401异常；
        // BaseServerProtectConfigure 开启微服务防护，避免客户端绕过网关直接请求微服务；
        return new String[]{
                BaseAuthExceptionConfigure.class.getName(),
                BaseOAuth2FeignConfigure.class.getName(),
                BaseServerProtectConfigure.class.getName()
        };
    }
}
