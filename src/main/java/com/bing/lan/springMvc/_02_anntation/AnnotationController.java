package com.bing.lan.springMvc._02_anntation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 蓝兵 on 2018/4/26.
 */

@Controller
public class AnnotationController {

    /**
     * RequestMapping 映射路径
     */
    @RequestMapping("/method1")
    public ModelAndView method1(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("method1() : ");
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Map.Entry<String, String[]> stringEntry : parameterMap.entrySet()) {
            System.out.println("method1(): " + stringEntry.getKey());
            System.out.println("method1(): " + Arrays.toString(stringEntry.getValue()));
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("key", "method1");
        modelAndView.setViewName("forward:/WEB-INF/views/springMvc.jsp");

        return modelAndView;
    }

    @RequestMapping("/method2")
    public ModelAndView method2(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("method2() : ");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("key", "method2");
        modelAndView.setViewName("forward:/WEB-INF/views/springMvc.jsp");
        return modelAndView;
    }
}
