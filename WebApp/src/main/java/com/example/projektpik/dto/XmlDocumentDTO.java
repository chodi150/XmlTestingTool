package com.example.projektpik.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Piotr on 20.05.2018.
 */

@Builder
@Getter
@Setter
@EqualsAndHashCode
public class  XmlDocumentDTO {
    private String xmlBody;

    public XmlDocumentDTO() {
        this.xmlBody = "";
    }

    public XmlDocumentDTO(String xmlBody) {
        this.xmlBody = xmlBody;
    }
}
