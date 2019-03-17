package com.xt.springboot.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author xt
 * @date 2019/3/17 - 9:04
 * @description
 */
@Component
public class HelloApplicationRunner implements ApplicationRunner{
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        System.out.println("HelloApplicationRunner...applicationArguments");
    }
}
