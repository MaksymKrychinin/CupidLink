package com.example.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ThymeleafController {

    @RequestMapping("/thymeleaf")
    ModelAndView getModelAndView() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("student1", "Zakhar");
        modelAndView.addObject("student2", "Maksym");
        modelAndView.addObject("student3", "Yarik");
        return modelAndView;
    }
}
