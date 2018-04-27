package com.bing.lan.springMvc._01_implement;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 蓝兵 on 2018/4/26.
 */

public class HelloMvcController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        System.out.println("handleRequest() : ");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("key", "Hello SpringMvc");
        modelAndView.setViewName("forward:/WEB-INF/views/springMvc.jsp");
        return modelAndView;
    }
}
