package com.example.projektpik.controllers;

import business.XMLValidator;
import com.example.projektpik.domain.XmlDocument;
import com.example.projektpik.database.XmlDocumentRepository;
import com.example.projektpik.domain.XmlDocumentCreator;
import com.example.projektpik.dto.XmlDocumentDTO;
import com.example.projektpik.exception.NoSuchXmlException;
import com.example.projektpik.facade.XmlDocumentFacade;
import com.example.projektpik.models.Student;
import com.example.projektpik.utils.TempFileCreator;
import exception.NotValidXmlException;
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
    XmlDocumentFacade xmlDocumentFacade;

    @RequestMapping(value = "/deleteXml/{id}", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteXml(@PathVariable Long id){
        try {
            xmlDocumentFacade.deleteXml(id);
        } catch (NoSuchXmlException e) {
            return ResponseEntity.status(400).build();
        }
        return ResponseEntity.status(200).build();
    }

    @RequestMapping(value = "/saveXml", method = RequestMethod.POST, consumes = MediaType.TEXT_XML_VALUE)
    public ResponseEntity<Void> saveXml(@RequestBody String xml){
        try {
            xmlDocumentFacade.validateXml(xml);
        } catch (NotValidXmlException e) {
            return ResponseEntity.status(400).build();
        } catch (XmlValidationException e) {
            return ResponseEntity.status(500).build();
        }
        xmlDocumentFacade.saveXml(xml);
        return ResponseEntity.status(200).build();
    }

    @RequestMapping(value = "/updateXml/{id}", method = RequestMethod.POST, consumes = MediaType.TEXT_XML_VALUE)
    public ResponseEntity<Void> updateOrInsertXml(@PathVariable Long id, @RequestBody String xml){
        try {
            xmlDocumentFacade.validateXml(xml);
        } catch (NotValidXmlException e) {
            return ResponseEntity.status(400).build();
        } catch (XmlValidationException e) {
            return ResponseEntity.status(500).build();
        }
        xmlDocumentFacade.updateXml(xml, id);
        return ResponseEntity.status(200).build();
    }

    @RequestMapping(value = "/getXml/{id}", method = RequestMethod.GET, produces = MediaType.TEXT_XML_VALUE)
    public ResponseEntity<String> getXml(@PathVariable Long id){
        XmlDocumentDTO xmlDocumentDTO;
        try {
            xmlDocumentDTO = xmlDocumentFacade.getXmlById(id);
        } catch (NoSuchXmlException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(xmlDocumentDTO.getXmlBody());
    }

    @RequestMapping(value = "/getXmlEditable/{id}", method = RequestMethod.GET, produces = MediaType.TEXT_XML_VALUE)
    public String getXmlEditable(@PathVariable Long id, Model model){
        XmlDocumentDTO xmlDocumentDTO;
        try {
            xmlDocumentDTO = xmlDocumentFacade.getXmlById(id);
        } catch (NoSuchXmlException e) {
            return "editXml";
        }
        model.addAttribute("xmlDocumentDTO", xmlDocumentDTO);
        model.addAttribute("id", id);
        return "editXml";
    }

    @RequestMapping(value = "/getXml", method = RequestMethod.GET, produces = MediaType.TEXT_XML_VALUE)
    public ResponseEntity<String> getXml(){
        String allXmls;
        try {
            allXmls = xmlDocumentFacade.getAllXmls();
        } catch (NoSuchXmlException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("<xmldocuments>\n" + allXmls + "\n</xmldocuments>");
    }

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