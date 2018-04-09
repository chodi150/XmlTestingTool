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
import javax.xml.bind.annotation.XmlType;


/**
 * Set of elements used to identify a financial institution.
 * 
 * <p>Java-Klasse f�r FinancialInstitutionIdentification7__1 complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="FinancialInstitutionIdentification7__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BIC" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.03}BICIdentifier" minOccurs="0"/>
 *         &lt;element name="ClrSysMmbId" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.03}ClearingSystemMemberIdentification2" minOccurs="0"/>
 *         &lt;element name="Nm" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.03}Max140Text" minOccurs="0"/>
 *         &lt;element name="PstlAdr" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.03}PostalAddress6__1" minOccurs="0"/>
 *         &lt;element name="Othr" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.03}GenericFinancialIdentification1__1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FinancialInstitutionIdentification7__1", propOrder = {
    "bic",
    "clrSysMmbId",
    "nm",
    "pstlAdr",
    "othr"
})
public class FinancialInstitutionIdentification71 {

    @XmlElement(name = "BIC")
    protected String bic;
    @XmlElement(name = "ClrSysMmbId")
    protected ClearingSystemMemberIdentification2 clrSysMmbId;
    @XmlElement(name = "Nm")
    protected String nm;
    @XmlElement(name = "PstlAdr")
    protected PostalAddress61 pstlAdr;
    @XmlElement(name = "Othr")
    protected GenericFinancialIdentification11 othr;

    /**
     * Ruft den Wert der bic-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBIC() {
        return bic;
    }

    /**
     * Legt den Wert der bic-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBIC(String value) {
        this.bic = value;
    }

    /**
     * Ruft den Wert der clrSysMmbId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ClearingSystemMemberIdentification2 }
     *     
     */
    public ClearingSystemMemberIdentification2 getClrSysMmbId() {
        return clrSysMmbId;
    }

    /**
     * Legt den Wert der clrSysMmbId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ClearingSystemMemberIdentification2 }
     *     
     */
    public void setClrSysMmbId(ClearingSystemMemberIdentification2 value) {
        this.clrSysMmbId = value;
    }

    /**
     * Ruft den Wert der nm-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNm() {
        return nm;
    }

    /**
     * Legt den Wert der nm-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNm(String value) {
        this.nm = value;
    }

    /**
     * Ruft den Wert der pstlAdr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PostalAddress61 }
     *     
     */
    public PostalAddress61 getPstlAdr() {
        return pstlAdr;
    }

    /**
     * Legt den Wert der pstlAdr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PostalAddress61 }
     *     
     */
    public void setPstlAdr(PostalAddress61 value) {
        this.pstlAdr = value;
    }

    /**
     * Ruft den Wert der othr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GenericFinancialIdentification11 }
     *     
     */
    public GenericFinancialIdentification11 getOthr() {
        return othr;
    }

    /**
     * Legt den Wert der othr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GenericFinancialIdentification11 }
     *     
     */
    public void setOthr(GenericFinancialIdentification11 value) {
        this.othr = value;
    }

}
