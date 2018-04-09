//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.04.09 um 09:52:58 PM CEST 
//


package com.example.projektpik.models.pain1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Provides the details on the user identification or any user key that allows to check if the initiating party is allowed to issue the transaction.
 * 
 * <p>Java-Klasse f�r Authorisation1Choice complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Authorisation1Choice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="Cd" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.03}Authorisation1Code"/>
 *           &lt;element name="Prtry" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.03}Max128Text"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Authorisation1Choice", propOrder = {
    "cd",
    "prtry"
})
public class Authorisation1Choice {

    @XmlElement(name = "Cd")
    @XmlSchemaType(name = "string")
    protected Authorisation1Code cd;
    @XmlElement(name = "Prtry")
    protected String prtry;

    /**
     * Ruft den Wert der cd-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Authorisation1Code }
     *     
     */
    public Authorisation1Code getCd() {
        return cd;
    }

    /**
     * Legt den Wert der cd-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Authorisation1Code }
     *     
     */
    public void setCd(Authorisation1Code value) {
        this.cd = value;
    }

    /**
     * Ruft den Wert der prtry-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrtry() {
        return prtry;
    }

    /**
     * Legt den Wert der prtry-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrtry(String value) {
        this.prtry = value;
    }

}
