package com.xt.springboot.controller;

import com.xt.springboot.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xt
 * @date 2019/3/13 - 16:00
 * @description
 */
@ControllerAdvice
public class MyExceptionHandler {

    // 浏览器和客户端返回的都是 json, 没有自适应
   /* @ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    public Map<String, Object> handleException(Exception e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", "user.not exists");
        map.put("msg", e.getMessage());
        return map;
    }*/

   // 转发到 /error 进行自适应响应效果处理
   @ExceptionHandler(UserNotExistException.class)
   public String handleException(Exception e, HttpServletRequest request){
       Map<String, Object> map = new HashMap<>();
       // 传入我们自己的错误状态码 4xx 5xx，否则就不会进入定制错误页面的解析流程
       /**
        * Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code")
        */
       request.setAttribute("javax.servlet.error.status_code", 500);
       map.put("code", "user.not exists");
       map.put("msg", e.getMessage());
       request.setAttribute("ext", map);
       // 转发到 /error
       return "forward:/error";
   }
}
