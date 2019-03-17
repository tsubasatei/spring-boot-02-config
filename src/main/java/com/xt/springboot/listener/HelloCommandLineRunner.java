package com.xt.springboot.listener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author xt
 * @date 2019/3/17 - 9:06
 * @description
 */
@Component
public class HelloCommandLineRunner implements CommandLineRunner{
    @Override
    public void run(String... strings) throws Exception {
        System.out.println("HelloCommandLineRunner...run..."+ Arrays.asList(strings));
    }
}
