package com.cpiaoju.base.common.annotation;

import com.cpiaoju.base.common.configure.BaseLettuceRedisConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author ziyou
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(BaseLettuceRedisConfigure.class)
public @interface EnableBaseLettuceRedis {

}
