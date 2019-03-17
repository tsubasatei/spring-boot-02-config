package com.xt.springboot.controller;

import com.xt.springboot.beans.User;
import com.xt.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xt
 * @date 2019/3/17 - 6:34
 * @description
 */
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
