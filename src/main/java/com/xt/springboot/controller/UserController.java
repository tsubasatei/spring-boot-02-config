package com.xt.springboot.controller;

import com.xt.springboot.beans.User;
import com.xt.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//这个类的所有方法返回的数据直接写给浏览器，（如果是对象转为json数据）
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getById(@PathVariable Integer id) {
        return userRepository.findOne(id);
    }

    @GetMapping("/user")
    public User save(User user) {
        return userRepository.saveAndFlush(user);
    }
}
