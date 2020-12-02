package com.cpiaoju.base.server.test.service;

import com.cpiaoju.base.common.constant.BaseServerConstant;
import com.cpiaoju.base.server.test.service.fallback.HelloServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ziyou
 */
@FeignClient(value = BaseServerConstant.BASE_SERVER_SYSTEM, contextId = "helloServiceClient", fallbackFactory = HelloServiceFallback.class)
public interface IHelloService {

    @GetMapping("hello")
    String hello(@RequestParam String name);

}
