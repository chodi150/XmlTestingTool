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
 * <p>Java-Klasse f�r ChequeDelivery1Code.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ChequeDelivery1Code">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MLDB"/>
 *     &lt;enumeration value="MLCD"/>
 *     &lt;enumeration value="MLFA"/>
 *     &lt;enumeration value="CRDB"/>
 *     &lt;enumeration value="CRCD"/>
 *     &lt;enumeration value="CRFA"/>
 *     &lt;enumeration value="PUDB"/>
 *     &lt;enumeration value="PUCD"/>
 *     &lt;enumeration value="PUFA"/>
 *     &lt;enumeration value="RGDB"/>
 *     &lt;enumeration value="RGCD"/>
 *     &lt;enumeration value="RGFA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ChequeDelivery1Code")
@XmlEnum
public enum ChequeDelivery1Code {


    /**
     * Cheque is to be sent through mail services to debtor.
     * 
     */
    MLDB,

    /**
     * Cheque is to be sent through mail services to creditor.
     * 
     */
    MLCD,

    /**
     * Cheque is to be sent through mail services to creditor agent.
     * 
     */
    MLFA,

    /**
     * Cheque is to be sent through courier services to debtor.
     * 
     */
    CRDB,

    /**
     * Cheque is to be sent through courier services to creditor.
     * 
     */
    CRCD,

    /**
     * Cheque is to be sent through courier services to creditor agent.
     * 
     */
    CRFA,

    /**
     * Cheque will be picked up by the debtor.
     * 
     */
    PUDB,

    /**
     * Cheque will be picked up by the creditor
     * 
     */
    PUCD,

    /**
     * Cheque will be picked up by the creditor agent.
     * 
     */
    PUFA,

    /**
     * Cheque is to be sent through registered mail services to debtor
     * 
     */
    RGDB,

    /**
     * Cheque is to be sent through registered mail services to creditor.
     * 
     */
    RGCD,

    /**
     * Cheque is to be sent through registered mail services to creditor agent.
     * 
     */
    RGFA;

    public String value() {
        return name();
    }

    public static ChequeDelivery1Code fromValue(String v) {
        return valueOf(v);
    }

}
