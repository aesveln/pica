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
 * <p>Java class for LanguagesEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LanguagesEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ALB"/>
 *     &lt;enumeration value="ARA"/>
 *     &lt;enumeration value="BEL"/>
 *     &lt;enumeration value="BUL"/>
 *     &lt;enumeration value="CAT"/>
 *     &lt;enumeration value="CHI"/>
 *     &lt;enumeration value="SCR"/>
 *     &lt;enumeration value="CZE"/>
 *     &lt;enumeration value="DAN"/>
 *     &lt;enumeration value="DUT"/>
 *     &lt;enumeration value="ENG"/>
 *     &lt;enumeration value="FIN"/>
 *     &lt;enumeration value="FRE"/>
 *     &lt;enumeration value="GER"/>
 *     &lt;enumeration value="GRE"/>
 *     &lt;enumeration value="HEB"/>
 *     &lt;enumeration value="HIN"/>
 *     &lt;enumeration value="HUN"/>
 *     &lt;enumeration value="IND"/>
 *     &lt;enumeration value="GLE"/>
 *     &lt;enumeration value="ITA"/>
 *     &lt;enumeration value="JPN"/>
 *     &lt;enumeration value="LAV"/>
 *     &lt;enumeration value="LIT"/>
 *     &lt;enumeration value="MAC"/>
 *     &lt;enumeration value="MAY"/>
 *     &lt;enumeration value="MLT"/>
 *     &lt;enumeration value="NOR"/>
 *     &lt;enumeration value="POL"/>
 *     &lt;enumeration value="POR"/>
 *     &lt;enumeration value="RUM"/>
 *     &lt;enumeration value="RUS"/>
 *     &lt;enumeration value="SCC"/>
 *     &lt;enumeration value="SLO"/>
 *     &lt;enumeration value="SPA"/>
 *     &lt;enumeration value="THA"/>
 *     &lt;enumeration value="TUR"/>
 *     &lt;enumeration value="UKR"/>
 *     &lt;enumeration value="VIE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LanguagesEnum", namespace = "http://enumeration.rules.openl.org")
@XmlEnum
public enum LanguagesEnum {

    ALB,
    ARA,
    BEL,
    BUL,
    CAT,
    CHI,
    SCR,
    CZE,
    DAN,
    DUT,
    ENG,
    FIN,
    FRE,
    GER,
    GRE,
    HEB,
    HIN,
    HUN,
    IND,
    GLE,
    ITA,
    JPN,
    LAV,
    LIT,
    MAC,
    MAY,
    MLT,
    NOR,
    POL,
    POR,
    RUM,
    RUS,
    SCC,
    SLO,
    SPA,
    THA,
    TUR,
    UKR,
    VIE;

    public String value() {
        return name();
    }

    public static LanguagesEnum fromValue(String v) {
        return valueOf(v);
    }

}
