package com.example.projektpik.facade;

import business.XMLValidator;
import com.example.projektpik.database.XmlDocumentRepository;
import com.example.projektpik.domain.XmlDocument;
import com.example.projektpik.domain.XmlDocumentCreator;
import com.example.projektpik.dto.XmlDocumentDTO;
import com.example.projektpik.exception.NoSuchXmlException;
import com.example.projektpik.utils.TempFileCreator;
import exception.NotValidXmlException;
import exception.XmlValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * created on 2018-05-27
 * <p>
 * by Piotr Chodyko
 */

@Configuration
public class XmlDocumentFacade {
    @Autowired
    XmlDocumentRepository xmlDocumentRepository;

    @Autowired
    XmlDocumentCreator xmlDocumentCreator;


    private XMLValidator xmlValidator = new XMLValidator();


    public void deleteXml(Long id) throws NoSuchXmlException {
        xmlDocumentRepository.findById(id).orElseThrow(()-> new NoSuchXmlException("No such elment in repository")).dto();
        xmlDocumentRepository.deleteById(id);
    }

    public void saveXml(String xml){
        XmlDocumentDTO xmlDocumentDTO = XmlDocumentDTO.builder().xmlBody(xml).build();
        xmlDocumentRepository.save(xmlDocumentCreator.from(xmlDocumentDTO));
    }

    public void validateXml(String xml) throws NotValidXmlException, XmlValidationException {
        try {
            File tempFile = TempFileCreator.createTempFile(xml);
            if(!xmlValidator.hasXmlValidMarkups(tempFile))
                throw new NotValidXmlException("Not valid xml");
        } catch (IOException | XmlValidationException e) {
            throw new XmlValidationException("Problems while validating xml", e);
        }
    }

    public void updateXml(String xml, Long id){
        xmlDocumentRepository.save(XmlDocument.builder().id(id).xmlBody(xml).build());
    }

    public XmlDocumentDTO getXmlById(Long id) throws NoSuchXmlException {
        return xmlDocumentRepository.findById(id).orElseThrow(()-> new NoSuchXmlException("No such elment in repository")).dto();
    }

    public ArrayList<XmlDocument> getAllXmls() {
        return new ArrayList<>(xmlDocumentRepository.findAll());
    }

}
