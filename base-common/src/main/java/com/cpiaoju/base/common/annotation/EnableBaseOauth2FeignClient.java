package com.cpiaoju.base.common.annotation;

import com.cpiaoju.base.common.configure.BaseOAuth2FeignConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author ziyou
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(BaseOAuth2FeignConfigure.class)
public @interface EnableBaseOauth2FeignClient {

}
