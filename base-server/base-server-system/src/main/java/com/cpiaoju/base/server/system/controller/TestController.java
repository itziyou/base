package com.cpiaoju.base.server.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author ziyou
 */
@RestController
public class TestController {

    @GetMapping("hello")
    public String hello(String name) {
        return "hello" + name;
    }

    @GetMapping("info")
    public String test() {
        return "base-server-system";
    }

    @GetMapping("currentUser")
    public Principal currentUser(Principal principal) {
        return principal;
    }
}