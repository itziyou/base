package com.cpiaoju.base.common.annotation;

import com.cpiaoju.base.common.configure.BaseAuthExceptionConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author ziyou
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(BaseAuthExceptionConfigure.class)
public @interface EnableBaseAuthExceptionHandler {
}
