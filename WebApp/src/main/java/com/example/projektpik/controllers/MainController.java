package com.example.projektpik.controllers;

import com.example.projektpik.domain.XmlDocument;
import com.example.projektpik.dto.XmlDocumentDTO;
import com.example.projektpik.exception.NoSuchXmlException;
import com.example.projektpik.facade.XmlDocumentFacade;
import exception.NotValidXmlException;
import exception.XmlValidationException;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;


@Controller
public class MainController {

    @Autowired
    XmlDocumentFacade xmlDocumentFacade;

    @RequestMapping(value = "/xml/{id}/delete/", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteXml(@PathVariable Long id) {
        try {
            xmlDocumentFacade.deleteXml(id);
        } catch (NoSuchXmlException e) {
            return ResponseEntity.status(400).build();
        }
        return ResponseEntity.status(200).build();
    }

    @GetMapping(value = "/xml/new/", produces = MediaType.TEXT_XML_VALUE)
    public String getXmlNew(Model model) {
        XmlDocumentDTO xmlDocumentDTO = new XmlDocumentDTO();
        model.addAttribute("xmlDocumentDTO", xmlDocumentDTO);
        return "add_xml";
    }

    @PostMapping(value = "/xml/new/", produces = MediaType.TEXT_XML_VALUE)
    public String getXmlNew(@ModelAttribute("xmlDocumentDTO") XmlDocumentDTO xmlDocumentDTO,
                            Model model) {
        try {
            xmlDocumentFacade.validateXml(xmlDocumentDTO.getXmlBody());
        } catch (NotValidXmlException | XmlValidationException e) {
            model.addAttribute("error", e.getMessage());
            return "add_xml";
        }
        xmlDocumentFacade.saveXml(xmlDocumentDTO.getXmlBody());
        return "redirect:/xml/list/";
    }


    @GetMapping(value = "/xml/{id}/edit/", produces = MediaType.TEXT_XML_VALUE)
    public String getXmlEditable(@PathVariable Long id, Model model) {
        XmlDocumentDTO xmlDocumentDTO;
        try {
            xmlDocumentDTO = xmlDocumentFacade.getXmlById(id);
        } catch (NoSuchXmlException e) {
            return "redirect:/applicantList";
        }
        model.addAttribute("xmlDocumentDTO", xmlDocumentDTO);
        model.addAttribute("id", id);
        return "edit_xml";
    }

    @PostMapping(value = "/xml/{id}/edit/", produces = MediaType.TEXT_XML_VALUE)
    public String getXmlEditable(@PathVariable Long id,
                                 @ModelAttribute("xmlDocumentDTO") XmlDocumentDTO xmlDocumentDTO,
                                 Model model) {
        try {
            xmlDocumentFacade.validateXml(xmlDocumentDTO.getXmlBody());
        } catch (NotValidXmlException | XmlValidationException e) {
            model.addAttribute("error", e.getMessage());
            return "edit_xml";
        }
        xmlDocumentFacade.updateXml(xmlDocumentDTO.getXmlBody(), id);
        return "redirect:/xml/list/";
    }

    @RequestMapping(value = "/xml/list/", method = RequestMethod.GET, produces = MediaType.TEXT_XML_VALUE)
    public String getXml(Model model) {
        ArrayList<XmlDocument> allXmls = xmlDocumentFacade.getAllXmls();
        allXmls.sort((xmlDocument, t1) -> {
            if (xmlDocument.getId() > t1.getId())
                return 1;
            else return 0;
        });
        model.addAttribute("allXmls", allXmls);
        return "list_xml";
    }


    @RequestMapping("/")
    public String loginMessage() {
        return "index";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }

}