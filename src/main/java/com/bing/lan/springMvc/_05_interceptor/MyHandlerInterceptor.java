package com.bing.lan.springMvc._05_interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 蓝兵 on 2018/4/27.
 */

public class MyHandlerInterceptor implements HandlerInterceptor {

    /**
     * preHandle:执行处理器前调用 ,返回true or false    如果为false,拦截请求
     * postHandle:处理器调用完成后,但是视图合并前
     * afterCompletion:视图合并后调用
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
        System.out.println("preHandle(): ");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle(): ");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
            Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion(): ");
    }
}
