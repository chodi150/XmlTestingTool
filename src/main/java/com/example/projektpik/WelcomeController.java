package com.example.projektpik;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class WelcomeController {

    List<Student> students = new ArrayList<>();
    @Value("${welcome.message:test}")
    private String message = "Hello World!!!";

    @RequestMapping("/Hello")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        return "welcome";
    }

    @RequestMapping("/addStudent")
    public void addStudent(@RequestBody Student student){
        students.add(student);
    }

}
