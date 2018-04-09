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
 * <p>Java-Klasse f�r ExternalClearingSystemIdentification1Code.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ExternalClearingSystemIdentification1Code">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;minLength value="1"/>
 *     &lt;maxLength value="5"/>
 *     &lt;enumeration value="ATBLZ"/>
 *     &lt;enumeration value="AUBSB"/>
 *     &lt;enumeration value="CACPA"/>
 *     &lt;enumeration value="CHBCC"/>
 *     &lt;enumeration value="CHSIC"/>
 *     &lt;enumeration value="CNAPS"/>
 *     &lt;enumeration value="DEBLZ"/>
 *     &lt;enumeration value="ESNCC"/>
 *     &lt;enumeration value="GBDSC"/>
 *     &lt;enumeration value="GRBIC"/>
 *     &lt;enumeration value="HKNCC"/>
 *     &lt;enumeration value="IENCC"/>
 *     &lt;enumeration value="INFSC"/>
 *     &lt;enumeration value="ITNCC"/>
 *     &lt;enumeration value="JPZGN"/>
 *     &lt;enumeration value="NZNCC"/>
 *     &lt;enumeration value="PLKNR"/>
 *     &lt;enumeration value="PTNCC"/>
 *     &lt;enumeration value="RUCBC"/>
 *     &lt;enumeration value="SESBA"/>
 *     &lt;enumeration value="SGIBG"/>
 *     &lt;enumeration value="THCBC"/>
 *     &lt;enumeration value="TWNCC"/>
 *     &lt;enumeration value="USABA"/>
 *     &lt;enumeration value="USPID"/>
 *     &lt;enumeration value="ZANCC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ExternalClearingSystemIdentification1Code")
@XmlEnum
public enum ExternalClearingSystemIdentification1Code {

    ATBLZ,
    AUBSB,
    CACPA,
    CHBCC,
    CHSIC,
    CNAPS,
    DEBLZ,
    ESNCC,
    GBDSC,
    GRBIC,
    HKNCC,
    IENCC,
    INFSC,
    ITNCC,
    JPZGN,
    NZNCC,
    PLKNR,
    PTNCC,
    RUCBC,
    SESBA,
    SGIBG,
    THCBC,
    TWNCC,
    USABA,
    USPID,
    ZANCC;

    public String value() {
        return name();
    }

    public static ExternalClearingSystemIdentification1Code fromValue(String v) {
        return valueOf(v);
    }

}
