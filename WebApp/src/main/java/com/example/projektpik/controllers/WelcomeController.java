package com.example.projektpik.controllers;

import business.XMLValidator;
import com.example.projektpik.domain.XmlDocument;
import com.example.projektpik.database.XmlDocumentRepository;
import com.example.projektpik.domain.XmlDocumentCreator;
import com.example.projektpik.dto.XmlDocumentDTO;
import com.example.projektpik.exception.NoSuchXmlException;
import com.example.projektpik.models.Student;
import com.example.projektpik.utils.TempFileCreator;
import exception.XmlValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class WelcomeController {

    @Autowired
    XmlDocumentRepository xmlDocumentRepository;

    @Autowired
    XmlDocumentCreator xmlDocumentCreator;

    XMLValidator xmlValidator = new XMLValidator();

    @RequestMapping(value = "/saveXml", method = RequestMethod.POST, consumes = MediaType.TEXT_XML_VALUE)
    public ResponseEntity<Void> saveXml(@RequestBody String xml){

        try {
            File tempFile = TempFileCreator.createTempFile(xml);
            if(!xmlValidator.hasXmlValidMarkups(tempFile))
                return ResponseEntity.status(500).build();
        } catch (XmlValidationException | IOException e) {
            return ResponseEntity.status(500).build();
        }
        XmlDocumentDTO xmlDocumentDTO = XmlDocumentDTO.builder().xmlBody(xml).build();
        xmlDocumentRepository.save(xmlDocumentCreator.from(xmlDocumentDTO));

        return ResponseEntity.status(200).build();
    }

    @RequestMapping(value = "/updateOrInsertXml/{id}", method = RequestMethod.POST, consumes = MediaType.TEXT_XML_VALUE)
    public void updateOrInsertXml(@PathVariable Long id, @RequestBody String xml){
        xmlDocumentRepository.save(XmlDocument.builder().id(id).xmlBody(xml).build());
    }

    @RequestMapping(value = "/getXml/{id}", method = RequestMethod.GET, produces = MediaType.TEXT_XML_VALUE)
    public ResponseEntity<String> getXml(@PathVariable Long id){
        XmlDocumentDTO xmlDocumentDTO = null;
        try {
            xmlDocumentDTO = xmlDocumentRepository.findById(id).orElseThrow(()-> new NoSuchXmlException("No such elment in repository")).dto();
        } catch (NoSuchXmlException e) {
           return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(xmlDocumentDTO.getXmlBody());
    }

    @RequestMapping(value = "/getXmlEditable/{id}", method = RequestMethod.GET, produces = MediaType.TEXT_XML_VALUE)
    public String getXmlEditable(@PathVariable Long id, Model model){
        XmlDocumentDTO xmlDocumentDTO = null;
        try {
            xmlDocumentDTO = xmlDocumentRepository.findById(id).orElseThrow(()-> new NoSuchXmlException("No such elment in repository")).dto();
        } catch (NoSuchXmlException e) {
            return "editXml";
        }
        model.addAttribute("xmlDocumentDTO", xmlDocumentDTO);
        model.addAttribute("id", id);
        return "editXml";
    }

    @RequestMapping(value = "/getXml", method = RequestMethod.GET, produces = MediaType.TEXT_XML_VALUE)
    public ResponseEntity<String> getXml(){
        String xmls =  xmlDocumentRepository.findAll()
                .stream()
                .map(XmlDocument::dto)
                .map(XmlDocumentDTO::getXmlBody)
                .collect(Collectors.joining("\n"));
        if (xmls == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("<xmldocuments>\n" + xmls + "\n</xmldocuments>");
    }

    @GetMapping("/test")
    public String welcomeForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        XmlDocument xmlDocument = new XmlDocument();
//        xmlDocument.setId(1L);
        xmlDocument.setXmlBody("SIema");
        xmlDocumentRepository.save(xmlDocument);
        return "welcome";
    }

    @PostMapping("/test")
    public String welcomeSubmit(@ModelAttribute("student") Student student) {
        return "result";
    }

}