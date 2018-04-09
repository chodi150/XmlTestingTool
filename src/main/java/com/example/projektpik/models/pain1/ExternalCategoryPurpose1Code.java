//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.04.09 um 09:52:58 PM CEST 
//


package com.example.projektpik.models.pain1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ExternalCategoryPurpose1Code.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ExternalCategoryPurpose1Code">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;minLength value="1"/>
 *     &lt;maxLength value="4"/>
 *     &lt;enumeration value="BONU"/>
 *     &lt;enumeration value="CASH"/>
 *     &lt;enumeration value="CCRD"/>
 *     &lt;enumeration value="CORT"/>
 *     &lt;enumeration value="DCRD"/>
 *     &lt;enumeration value="DIVI"/>
 *     &lt;enumeration value="EPAY"/>
 *     &lt;enumeration value="GOVT"/>
 *     &lt;enumeration value="HEDG"/>
 *     &lt;enumeration value="ICCP"/>
 *     &lt;enumeration value="IDCP"/>
 *     &lt;enumeration value="INTC"/>
 *     &lt;enumeration value="INTE"/>
 *     &lt;enumeration value="LOAN"/>
 *     &lt;enumeration value="OTHR"/>
 *     &lt;enumeration value="PENS"/>
 *     &lt;enumeration value="SALA"/>
 *     &lt;enumeration value="SECU"/>
 *     &lt;enumeration value="SSBE"/>
 *     &lt;enumeration value="SUPP"/>
 *     &lt;enumeration value="TAXS"/>
 *     &lt;enumeration value="TRAD"/>
 *     &lt;enumeration value="TREA"/>
 *     &lt;enumeration value="VATX"/>
 *     &lt;enumeration value="WHLD"/>
 *     &lt;enumeration value="CBLK"/>
 *     &lt;enumeration value="DVPM"/>
 *     &lt;enumeration value="FCOL"/>
 *     &lt;enumeration value="MP2B"/>
 *     &lt;enumeration value="MP2P"/>
 *     &lt;enumeration value="RVPM"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ExternalCategoryPurpose1Code")
@XmlEnum
public enum ExternalCategoryPurpose1Code {

    BONU("BONU"),
    CASH("CASH"),
    CCRD("CCRD"),
    CORT("CORT"),
    DCRD("DCRD"),
    DIVI("DIVI"),
    EPAY("EPAY"),
    GOVT("GOVT"),
    HEDG("HEDG"),
    ICCP("ICCP"),
    IDCP("IDCP"),
    INTC("INTC"),
    INTE("INTE"),
    LOAN("LOAN"),
    OTHR("OTHR"),
    PENS("PENS"),
    SALA("SALA"),
    SECU("SECU"),
    SSBE("SSBE"),
    SUPP("SUPP"),
    TAXS("TAXS"),
    TRAD("TRAD"),
    TREA("TREA"),
    VATX("VATX"),
    WHLD("WHLD"),
    CBLK("CBLK"),
    DVPM("DVPM"),
    FCOL("FCOL"),
    @XmlEnumValue("MP2B")
    MP_2_B("MP2B"),
    @XmlEnumValue("MP2P")
    MP_2_P("MP2P"),
    RVPM("RVPM");
    private final String value;

    ExternalCategoryPurpose1Code(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ExternalCategoryPurpose1Code fromValue(String v) {
        for (ExternalCategoryPurpose1Code c: ExternalCategoryPurpose1Code.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
