package com.example.projektpik;

import com.example.projektpik.business.ThymeleafTagInjector;
import com.example.projektpik.models.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@SpringBootApplication
public class ProjektpikApplication {

	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run(ProjektpikApplication.class, args);

		ThymeleafTagInjector thymeleafTagInjector = new ThymeleafTagInjector(appContext);
		Map<String, Object> map = new TreeMap<>();
		Student student = new Student();
		student.setName("DUPA");
		student.setSurname("KUPA");
		map.put("student",student);

		thymeleafTagInjector.injectTag(map, "hej");

	}
}
