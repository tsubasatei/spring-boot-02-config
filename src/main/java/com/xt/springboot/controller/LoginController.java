package com.xt.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author xt
 * @date 2019/3/12 - 13:37
 * @description
 */
@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session) {
        if("admin".equals(username) && "123456".equals(password)) {
            session.setAttribute("loginUser", username);
            // 登录成功 防止表单重复提交，可以重定向到主页
            return "redirect:/main.html";
        } else {
            // 登录失败
            map.put("msg", "用户名或密码错误");
            return "login";
        }
    }
}
