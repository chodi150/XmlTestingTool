//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.04.09 um 09:52:58 PM CEST 
//


package com.example.projektpik.models.pain1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r Authorisation1Code.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="Authorisation1Code">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AUTH"/>
 *     &lt;enumeration value="FDET"/>
 *     &lt;enumeration value="FSUM"/>
 *     &lt;enumeration value="ILEV"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Authorisation1Code")
@XmlEnum
public enum Authorisation1Code {


    /**
     * Indicates a file has been pre authorised or approved within the originating customer environment and no further approval is required.
     * 
     */
    AUTH,

    /**
     * Indicates that a file requires additional file level approval, with the ability to view both the payment information block and supporting customer credit transaction detail.
     * 
     */
    FDET,

    /**
     * Indicates that a file requires additional file level approval, with the ability to view only the payment information block level information.
     * 
     */
    FSUM,

    /**
     * Indicates that a file requires all customer transactions to be authorised or approved.
     * 
     */
    ILEV;

    public String value() {
        return name();
    }

    public static Authorisation1Code fromValue(String v) {
        return valueOf(v);
    }

}
