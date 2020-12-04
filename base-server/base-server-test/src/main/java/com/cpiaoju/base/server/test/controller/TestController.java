package com.cpiaoju.base.server.test.controller;

import com.cpiaoju.base.server.test.service.IHelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author ziyou
 */
@RestController
@RequiredArgsConstructor
public class TestController {
    private final IHelloService helloService;

    @GetMapping("hello")
    public String hello(String name) {
        return this.helloService.hello(name);
    }

    @GetMapping("test1")
    @PreAuthorize("hasAnyAuthority('user:add')")
    public String test1() {
        int i = 1 / 0;
        return "拥有'user:add'权限";
    }

    @GetMapping("test2")
    @PreAuthorize("hasAnyAuthority('user:update')")
    public String test2() {
        return "拥有'user:update'权限";
    }

    @GetMapping("user")
    public Principal currentUser(Principal principal) {
        return principal;
    }
}
