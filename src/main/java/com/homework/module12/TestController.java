package com.homework.module12;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/test")
@Controller
public class TestController {


    @GetMapping
    public ModelAndView testMethod(){
        ModelAndView result = new ModelAndView("test");
        return result;
    }
}
