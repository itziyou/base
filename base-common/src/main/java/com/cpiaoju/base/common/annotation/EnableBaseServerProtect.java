package com.cpiaoju.base.common.annotation;

import com.cpiaoju.base.common.configure.BaseServerProtectConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author ziyou
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(BaseServerProtectConfigure.class)
public @interface EnableBaseServerProtect {
}
