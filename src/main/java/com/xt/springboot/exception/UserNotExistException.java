package com.xt.springboot.exception;

/**
 * @author xt
 * @date 2019/3/13 - 15:46
 * @description
 */
public class UserNotExistException extends RuntimeException{
    public UserNotExistException() {
        super("用户不存在");
    }
}
