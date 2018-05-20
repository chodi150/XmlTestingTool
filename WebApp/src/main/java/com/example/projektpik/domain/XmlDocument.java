package com.example.projektpik.domain;

import com.example.projektpik.dto.XmlDocumentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Clob;

/**
 * Created by Piotr on 20.05.2018.
 */

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class XmlDocument
{
    @Id
    @GeneratedValue
    Long id;

    String xmlBody;

    public XmlDocumentDTO dto(){
        return XmlDocumentDTO.builder()
                .xmlBody(xmlBody)
                .build();
    }
}
