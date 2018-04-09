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
 * <p>Java-Klasse f�r CashAccountType4Code.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="CashAccountType4Code">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CASH"/>
 *     &lt;enumeration value="CHAR"/>
 *     &lt;enumeration value="COMM"/>
 *     &lt;enumeration value="TAXE"/>
 *     &lt;enumeration value="CISH"/>
 *     &lt;enumeration value="TRAS"/>
 *     &lt;enumeration value="SACC"/>
 *     &lt;enumeration value="CACC"/>
 *     &lt;enumeration value="SVGS"/>
 *     &lt;enumeration value="ONDP"/>
 *     &lt;enumeration value="MGLD"/>
 *     &lt;enumeration value="NREX"/>
 *     &lt;enumeration value="MOMA"/>
 *     &lt;enumeration value="LOAN"/>
 *     &lt;enumeration value="SLRY"/>
 *     &lt;enumeration value="ODFT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CashAccountType4Code")
@XmlEnum
public enum CashAccountType4Code {


    /**
     * Account used for the payment of cash.
     * 
     */
    CASH,

    /**
     * Account used for charges if different from the account for payment.
     * 
     */
    CHAR,

    /**
     * Account used for commission if different from the account for payment.
     * 
     */
    COMM,

    /**
     * Account used for taxes if different from the account for payment.
     * 
     */
    TAXE,

    /**
     * Account used for payment of income if different from the current cash account.
     * 
     */
    CISH,

    /**
     * Account used for trading if different from the current cash account.
     * 
     */
    TRAS,

    /**
     * Account used to post debit and credit entries, as a result of transactions cleared and settled through a specific clearing and settlement system.
     * 
     */
    SACC,

    /**
     * Account used to post debits and credits when no specific account has been nominated.
     * 
     */
    CACC,

    /**
     * Account used for savings.
     * 
     */
    SVGS,

    /**
     * Account used for overnight deposits.
     * 
     */
    ONDP,

    /**
     * Account used for a marginal lending facility.
     * 
     */
    MGLD,

    /**
     * Account used for non-resident external.
     * 
     */
    NREX,

    /**
     * Account used for money markets if different from the cash account.
     * 
     */
    MOMA,

    /**
     * Account used for loans.
     * 
     */
    LOAN,

    /**
     * Accounts used for salary payments.
     * 
     */
    SLRY,

    /**
     * Account is used for overdrafts.
     * 
     */
    ODFT;

    public String value() {
        return name();
    }

    public static CashAccountType4Code fromValue(String v) {
        return valueOf(v);
    }

}
