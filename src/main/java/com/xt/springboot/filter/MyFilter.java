package com.xt.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author xt
 * @date 2019/3/13 - 18:42
 * @description
 */
public class MyFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("MyFilter 的 doFilter...");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
