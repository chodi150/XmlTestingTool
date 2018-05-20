package com.example.projektpik.domain;

import com.example.projektpik.dto.XmlDocumentDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Piotr on 20.05.2018.
 */

@Configuration
public class XmlDocumentCreator {

    public XmlDocument from(XmlDocumentDTO xmlDocumentDTO) {
        return XmlDocument.builder()
                .xmlBody(xmlDocumentDTO.getXmlBody())
                .build();
    }
}
