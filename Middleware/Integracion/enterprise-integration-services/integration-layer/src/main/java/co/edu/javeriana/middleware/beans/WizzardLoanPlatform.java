package co.edu.javeriana.middleware.beans;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class WizzardLoanPlatform {

	
	public Map LoanPlatofrm (String mensaje) throws IOException, SAXException, ParserConfigurationException
	{
			mensaje = mensaje.replace("\n","");
			mensaje = mensaje.replace("\t","");
	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = factory.newDocumentBuilder();
	        InputSource is = new InputSource(new StringReader(mensaje));
	        Document doc =  builder.parse(is);
	        Map<String, String> parametros = new HashMap<String, String>();
//
//	        String numPrestamo = StringUtils.rightPad( doc.getElementsByTagName("il:numeroPrestamos").item(0).getTextContent(), 20);
//	        String montoSol = StringUtils.rightPad( doc.getElementsByTagName("il:montoSolicitado").item(0).getTextContent(), 20);
//	        String totalCargos = StringUtils.rightPad( doc.getElementsByTagName("il:totalCargos").item(0).getTextContent(), 10);

	        parametros.put("numPrestamo", StringUtils.rightPad( doc.getElementsByTagName("il:numeroPrestamos").item(0).getTextContent(), 20));
	        parametros.put("montoSol", StringUtils.rightPad( doc.getElementsByTagName("il:montoSolicitado").item(0).getTextContent(), 20));
	        parametros.put("totalCargos", StringUtils.rightPad( doc.getElementsByTagName("il:totalCargos").item(0).getTextContent(), 10));
	      //  mensaje = numPrestamo +"," +montoSol + "," +totalCargos;

	        return parametros;
	}
}
