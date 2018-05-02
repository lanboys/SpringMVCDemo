package com.bing.lan.springMvc._06_annotation._01_responseBody;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 蓝兵 on 2018/5/2.
 */

@Controller
public class ResponseBodyController {

    /**
     * 加上@responsebody后，返回结果直接写入HTTP response body中，不会被解析为跳转路径。
     * 比如异步请求，希望响应的结果是json数据，那么加上@responsebody后，就会直接返回json数据。
     */
    @RequestMapping("/foo1")
    public String foo1() {
        System.out.println("foo1(): ");
        return "redirect:/annotation.jsp";
    }

    /**
     * 请求转发到  /WEB-INF/views/foo2.jsp
     */
    @RequestMapping("/foo2")
    public void foo2() {
        System.out.println("foo2(): ");
    }

    /**
     * 加了标签，相当于返回值为空
     */
    @RequestMapping("/foo3")
    @ResponseBody
    public void foo3() {
        System.out.println("foo3(): ");
    }

    @RequestMapping("/foo4")
    @ResponseBody
    public String foo4() {
        System.out.println("foo4(): ");
        return "{\n" +
                "    \"code\": \"200\",\n" +
                "    \"data\": \"hello api interface\",\n" +
                "    \"msg\": \"success\"\n" +
                "}";
    }

    @RequestMapping("/foo5")
    public String foo5() {
        System.out.println("foo5(): ");
        return "{\n" +
                "    \"code\": \"200\",\n" +
                "    \"data\": \"hello api interface\",\n" +
                "    \"msg\": \"success\"\n" +
                "}";
    }
}
