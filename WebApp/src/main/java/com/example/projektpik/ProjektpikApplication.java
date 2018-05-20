package com.example.projektpik;

import business.TagInjector;
import business.XMLValidator;
import com.example.projektpik.database.XmlDocumentRepository;
import com.example.projektpik.models.Student;
import config.XMLConfig;
import exception.NotValidXmlException;
import file_handling.XMLFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@SpringBootApplication
public class ProjektpikApplication {

	public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
		ApplicationContext appContext = SpringApplication.run(ProjektpikApplication.class, args);
		XMLConfig xmlConfig = new XMLConfig();
		TagInjector thymeleafTagInjector = new TagInjector(xmlConfig.templateEngine(appContext));
		Map<String, Object> map = new TreeMap<>();
		Student student = new Student();
		student.setName("Kobe");
		student.setSurname("Bryant");
		map.put("student",student);

		try {
			thymeleafTagInjector.produceXmlWithInjectedTags(map, "hej");
		} catch (IOException e) {
			System.err.println("Houston mamy problem");
		}

	}
}
