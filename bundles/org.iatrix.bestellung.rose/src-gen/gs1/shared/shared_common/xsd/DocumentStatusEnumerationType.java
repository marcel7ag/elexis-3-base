//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v3.0.0 generiert 
// Siehe https://eclipse-ee4j.github.io/jaxb-ri 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2025.01.23 um 10:57:07 AM CET 
//


package gs1.shared.shared_common.xsd;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für DocumentStatusEnumerationType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <pre>
 * &lt;simpleType name="DocumentStatusEnumerationType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ADDITIONAL_TRANSMISSION"/&gt;
 *     &lt;enumeration value="COPY"/&gt;
 *     &lt;enumeration value="ORIGINAL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DocumentStatusEnumerationType")
@XmlEnum
public enum DocumentStatusEnumerationType {

    ADDITIONAL_TRANSMISSION,
    COPY,
    ORIGINAL;

    public String value() {
        return name();
    }

    public static DocumentStatusEnumerationType fromValue(String v) {
        return valueOf(v);
    }

}
