package com.xt.springboot.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author xt
 * @date 2019/3/17 - 8:56
 * @description
 */
public class HelloSpingApplicationRunnerListener implements SpringApplicationRunListener {

    // 必须有参构造器
    public HelloSpingApplicationRunnerListener(SpringApplication application, String[] args) {
    }

    @Override
    public void starting() {
        System.out.println("HelloSpingApplicationRunnerListener...starting...");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment configurableEnvironment) {
        Object o = configurableEnvironment.getSystemProperties().get("os.name");
        System.out.println("HelloSpingApplicationRunnerListener...environmentPrepared..."+ o);
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("HelloSpingApplicationRunnerListener...contextPrepared...");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("HelloSpingApplicationRunnerListener...contextLoaded...");
    }

    @Override
    public void finished(ConfigurableApplicationContext configurableApplicationContext, Throwable throwable) {
        System.out.println("HelloSpingApplicationRunnerListener...finished...");
    }
}
