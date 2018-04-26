package com.bing.lan.springMvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 蓝兵 on 2018/4/26.
 */

@Controller
public class AnnotationController {

    @RequestMapping("/method1")
    public ModelAndView method1(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        System.out.println("method1() : ");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("key", "method1");
        modelAndView.setViewName("springMvc.jsp");
        return modelAndView;
    }

    @RequestMapping("/method2")
    public ModelAndView method2(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        System.out.println("method2() : ");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("key", "method2");
        modelAndView.setViewName("springMvc.jsp");
        return modelAndView;
    }
}
