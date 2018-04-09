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
 * <p>Java-Klasse f�r RemittanceLocationMethod2Code.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="RemittanceLocationMethod2Code">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FAXI"/>
 *     &lt;enumeration value="EDIC"/>
 *     &lt;enumeration value="URID"/>
 *     &lt;enumeration value="EMAL"/>
 *     &lt;enumeration value="POST"/>
 *     &lt;enumeration value="SMSM"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RemittanceLocationMethod2Code")
@XmlEnum
public enum RemittanceLocationMethod2Code {


    /**
     * Remittance advice information must be faxed.
     * 
     */
    FAXI,

    /**
     * Remittance advice information must be sent through Electronic Data Interchange (EDI).
     * 
     */
    EDIC,

    /**
     * Remittance advice  information needs to be sent to a Uniform Resource Identifier (URI). URI  is a compact string of characters that uniquely identify an abstract or physical resource.  URI's are the super-set of identifiers, such as URLs, email addresses, ftp sites, etc, and as such, provide the syntax for all of the identification schemes.
     * 
     */
    URID,

    /**
     * Remittance advice  information must be sent through e-mail.
     * 
     */
    EMAL,

    /**
     * Remittance advice information must be sent through postal services.
     * 
     */
    POST,

    /**
     * Remittance advice  information must be sent through by phone as a short message service (SMS).
     * 
     */
    SMSM;

    public String value() {
        return name();
    }

    public static RemittanceLocationMethod2Code fromValue(String v) {
        return valueOf(v);
    }

}
