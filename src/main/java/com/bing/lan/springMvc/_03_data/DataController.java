package com.bing.lan.springMvc._03_data;

import com.bing.lan.springMvc.domian.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 蓝兵 on 2018/4/27.
 */

@Controller
public class DataController {

    @RequestMapping("/data")
    public ModelAndView data(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("data() : ");

        //原始 传值方式
        request.setAttribute("key", "data");
        ModelAndView modelAndView = new ModelAndView("forward:/WEB-INF/views/dataTest.jsp");

        return modelAndView;
    }

    @RequestMapping("/data1")
    public ModelAndView data1(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("data1() : ");

        ModelAndView modelAndView = new ModelAndView("forward:/WEB-INF/views/dataTest.jsp");
        modelAndView.addObject("key", "data1");

        return modelAndView;
    }

    /**
     * 无key传值 默认的key为 数据类型全小写
     */
    @RequestMapping("/data2")
    public ModelAndView data2(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("data2() : ");

        ModelAndView modelAndView = new ModelAndView("forward:/WEB-INF/views/dataTest.jsp");
        modelAndView.addObject("key", "data2");
        modelAndView.addObject("测试无key传值 默认的key为 数据类型全小写 string");
        modelAndView.addObject(new Date());
        modelAndView.addObject(new User("xiaohong", 16));

        return modelAndView;
    }

    /**
     * /WEB-INF/views/data3.jsp
     * 响应的视图  前缀(/WEB-INF/views/) + 请求路径(data3) + 后缀(.jsp)
     */
    @RequestMapping("/data3")
    @ModelAttribute("myUser")
    public User data3() {
    //public void data3() {
        System.out.println("data3() : ");
        return new User("xiaohong data3", 18);
    }

    /**
     * /WEB-INF/views/data4.jsp
     * 响应的视图  前缀(/WEB-INF/views/) + 返回值(test/data4) + 后缀(.jsp)
     * Model 用来传值 不传值 也可以不写
     */
    @RequestMapping("/data4")
    public String data4(Model model) {
        System.out.println("data4() : ");
        model.addAttribute("msg", "data4");
        return "test/data4";
    }

    /**
     * 请求转发
     * 响应视图 去掉前缀和后缀  /WEB-INF/views/test/data5.jsp
     */
    @RequestMapping("/data5")
    public String data5(Model model) {
        System.out.println("data5() : ");
        model.addAttribute("msg", "data5");
        return "forward:/WEB-INF/views/test/data5.jsp";
    }

    /**
     * 重定向 无法访问 /WEB-INF 内的资源, 所以data6.jsp 只能放在web下
     * 响应视图 去掉前缀和后缀  /data6.jsp
     */
    @RequestMapping("/data6")
    public String data6(Model model) {
        System.out.println("data6() : ");
        model.addAttribute("msg", "data6");
        return "redirect:/data6.jsp";
    }
}
