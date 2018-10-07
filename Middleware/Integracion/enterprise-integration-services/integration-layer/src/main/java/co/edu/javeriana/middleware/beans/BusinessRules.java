package co.edu.javeriana.middleware.beans;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class BusinessRules {

    public String validarMontoInicialCuentaAhorro(String msg) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        msg = msg.replace("\n", "");
        msg = msg.replace("\t", "");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(msg));
        Document doc = builder.parse(is);

        int montoInicial = Integer.parseInt(doc.getElementsByTagName("il:saldoInicial").item(0).getTextContent());
        int bono = 0;
        if (montoInicial > 3000000) {
            bono = 300000;
        } else if (montoInicial > 1000000) {
            bono = 200000;
        }
        montoInicial += bono;
        doc.getElementsByTagName("il:saldoInicial").item(0).setTextContent(String.valueOf(montoInicial));

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        StringWriter sw = new StringWriter();
        t.transform(new DOMSource(doc), new StreamResult(sw));


        msg = sw.toString();

        return msg;
    }

    public String validarMontoInicialCuentaCorriente(String msg) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        msg = msg.replace("\n", "");
        msg = msg.replace("\t", "");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(msg));
        Document doc = builder.parse(is);


        int montoInicial = Integer.parseInt(doc.getElementsByTagName("il:saldoInicial").item(0).getTextContent());
        int bono = 0;
        if (montoInicial > 3000000) {
            bono = 250000;
        } else if (montoInicial > 1000000) {
            bono = 150000;
        }
        montoInicial += bono;
        doc.getElementsByTagName("il:saldoInicial").item(0).setTextContent(String.valueOf(montoInicial));

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        StringWriter sw = new StringWriter();
        t.transform(new DOMSource(doc), new StreamResult(sw));


        msg = sw.toString();

        return msg;
    }

}
