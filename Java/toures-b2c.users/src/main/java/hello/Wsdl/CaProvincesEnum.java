//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-b10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.11.07 at 05:15:18 PM COT 
//


package hello.Wsdl;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CaProvincesEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CaProvincesEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AB"/>
 *     &lt;enumeration value="BC"/>
 *     &lt;enumeration value="PE"/>
 *     &lt;enumeration value="MB"/>
 *     &lt;enumeration value="NB"/>
 *     &lt;enumeration value="NS"/>
 *     &lt;enumeration value="NU"/>
 *     &lt;enumeration value="ON"/>
 *     &lt;enumeration value="QC"/>
 *     &lt;enumeration value="SK"/>
 *     &lt;enumeration value="NL"/>
 *     &lt;enumeration value="YT"/>
 *     &lt;enumeration value="NT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CaProvincesEnum", namespace = "http://enumeration.rules.openl.org")
@XmlEnum
public enum CaProvincesEnum {

    AB,
    BC,
    PE,
    MB,
    NB,
    NS,
    NU,
    ON,
    QC,
    SK,
    NL,
    YT,
    NT;

    public String value() {
        return name();
    }

    public static CaProvincesEnum fromValue(String v) {
        return valueOf(v);
    }

}