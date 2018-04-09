package com.example.projektpik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class ProjektpikApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjektpikApplication.class, args);
//		ApplicationContext appContext = SpringApplication.run(ProjektpikApplication.class, args);
//
//		SpringTemplateEngine engine = (SpringTemplateEngine) appContext.getBean("springTemplateEngine");
//
//		Map<String, String> pinfo = new HashMap<>();
//		Context context = new Context();
//		context.setVariable("pinfo", pinfo);
//		pinfo.put("test", "test");
//
//		String content = engine.process("example_file", context);
//
//		System.out.println(content);
	}
}
