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
 * <p>Java-Klasse f�r Instruction3Code.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="Instruction3Code">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CHQB"/>
 *     &lt;enumeration value="HOLD"/>
 *     &lt;enumeration value="PHOB"/>
 *     &lt;enumeration value="TELB"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Instruction3Code")
@XmlEnum
public enum Instruction3Code {


    /**
     * (Ultimate) creditor must be paid by cheque.
     * 
     */
    CHQB,

    /**
     * Amount of money must be held for the (ultimate) creditor, who will call. Pay on identification.
     * 
     */
    HOLD,

    /**
     * Please advise/contact (ultimate) creditor/claimant by phone
     * 
     */
    PHOB,

    /**
     * Please advise/contact (ultimate) creditor/claimant by the most efficient means of telecommunication.
     * 
     */
    TELB;

    public String value() {
        return name();
    }

    public static Instruction3Code fromValue(String v) {
        return valueOf(v);
    }

}
