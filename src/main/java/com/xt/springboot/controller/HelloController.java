package com.xt.springboot.controller;

import com.xt.springboot.exception.UserNotExistException;
import com.xt.starter.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author xt
 * @date 2019/3/6 - 13:17
 * @description
 */
@Controller
public class HelloController {

    @Autowired
    HelloService helloService;
//    @Value("${person.last-name}")
    private String name;

//    @GetMapping({"/", "/index.html"})
//    public String login() {
//        return "login";
//    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @GetMapping("/sayHello")
    public String sayHello() {
        return "Hello " + name;
    }

    @GetMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("hello", "<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan", "lisi", "wangwu"));
        return "success";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam String user) {
        if("aaa".equals(user)) {
            throw new UserNotExistException();
        }
        return "hello " + user;
    }

    @ResponseBody
    @GetMapping("/query")
    public Map<String, Object> query() {
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList("select * from jpa_persons");
        return mapList.get(0);
    }

    @GetMapping("/say")
    @ResponseBody
    public String say() {
       return helloService.sayHello("xt");
    }
}
