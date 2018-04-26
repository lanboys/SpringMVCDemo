package com.bing.lan.springMvc;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 蓝兵 on 2018/4/26.
 */

public class HelloMvcController implements org.springframework.web.servlet.mvc.Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        System.out.println("handleRequest() : ");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("key", "Hello SpringMvc");
        modelAndView.setViewName("springMvc.jsp");
        return modelAndView;
    }
}
