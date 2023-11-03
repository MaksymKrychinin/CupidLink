package com.example.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafController {


    @RequestMapping("/index")
    public ModelAndView getModelAndView() {
        ModelAndView modelAndView =
                new ModelAndView("index");
        List<Student> students = new ArrayList<>();
        Student student = new Student(1, "Zakhar");
        students.add(student);
        Student student2 = new Student(2, "Yaroslav");
        students.add(student2);
        Student student3 = new Student(3, "Maksym");
        students.add(student3);
        Student student4 = new Student(4, "Oleksandr");
        students.add(student4);
        Student student5 = new Student(5, "Oleksii");
        students.add(student5);
        students.add(null);
        modelAndView.addObject("students", students);
        return modelAndView;
    }

    class Student {
        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        int id;
        String name;

        public Student(int i, String name) {
            this.id = i;
            this.name = name;
        }
    }
}
