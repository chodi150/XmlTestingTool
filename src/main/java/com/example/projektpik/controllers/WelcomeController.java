package com.example.projektpik.controllers;

import com.example.projektpik.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class WelcomeController {

    @GetMapping("/test")
    public String welcomeForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "welcome";
    }

    @PostMapping("/test")
    public String welcomeSubmit(@ModelAttribute("student") Student student) {
        return "result";
    }

}