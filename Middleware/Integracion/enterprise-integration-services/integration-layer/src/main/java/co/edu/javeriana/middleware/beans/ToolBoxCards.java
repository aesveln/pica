package co.edu.javeriana.middleware.beans;


import com.ancientprogramming.fixedformat4j.format.FixedFormatManager;
import com.ancientprogramming.fixedformat4j.format.impl.FixedFormatManagerImpl;
import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

public class ToolBoxCards {


    private static FixedFormatManager manager = new FixedFormatManagerImpl();


    public String crearArchivoLF(String msg) throws IOException, SAXException, ParserConfigurationException {
        msg = msg.replace("\n","");
        msg = msg.replace("\t","");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(msg));
        Document doc =  builder.parse(is);


        String accountNumber = StringUtils.rightPad( doc.getElementsByTagName("il:numeroCuenta").item(0).getTextContent(), 20);
        String accountType = StringUtils.rightPad( doc.getElementsByTagName("il:tipoCuenta").item(0).getTextContent(), 20);
        String cardType = StringUtils.rightPad( doc.getElementsByTagName("il:tipoTarjeta").item(0).getTextContent(), 10);

        msg = accountNumber + accountType + cardType;

        return msg;
    }

}
