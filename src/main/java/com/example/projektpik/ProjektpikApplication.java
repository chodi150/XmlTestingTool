package com.example.projektpik;

import com.example.projektpik.models.Student;
import com.example.projektpik.models.pain1.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.print.Doc;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class ProjektpikApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ProjektpikApplication.class, args);
		//ApplicationContext appContext = SpringApplication.run(ProjektpikApplication.class, args);

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

		try {
			JAXBContext jc = JAXBContext.newInstance(Document.class);

			Unmarshaller unmarshaller = jc.createUnmarshaller();
			File xml = new File("example_file.xml");
			Document sc = (Document) unmarshaller.unmarshal(xml);

			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(sc, System.out);
		} catch (Exception e ){
			System.out.println("DUPA");
		}
	}
//		String xmlString = "";
//		try {
//			Student student = new Student();
//			student.setName("ASD");
//			student.setSex("ASDss");
//			student.setSurname("RET");
//			JAXBContext context = JAXBContext.newInstance(Student.class);
//			Marshaller m = context.createMarshaller();
//
//			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML
//
//			StringWriter sw = new StringWriter();
//			m.marshal(student, sw);
//			xmlString = sw.toString();
//			System.out.println(xmlString);
//		} catch (JAXBException e) {
//			e.printStackTrace();
//		}
	}
