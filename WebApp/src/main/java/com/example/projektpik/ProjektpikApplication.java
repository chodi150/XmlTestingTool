package com.example.projektpik;

import business.TagInjector;
import com.example.projektpik.models.Student;
import config.XMLConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.context.Context;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

@SpringBootApplication
public class ProjektpikApplication {

	public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
		ApplicationContext appContext = SpringApplication.run(ProjektpikApplication.class, args);
	}
}
