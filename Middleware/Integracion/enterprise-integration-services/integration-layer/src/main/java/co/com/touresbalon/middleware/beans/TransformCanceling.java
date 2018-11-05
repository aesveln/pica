package co.com.touresbalon.middleware.beans;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TransformCanceling {


    public Map TransformCancelingDataBase(String mensaje) throws IOException, SAXException, ParserConfigurationException, ParseException {

        Map<String, String> parametros = new HashMap<String, String>();

        parametros.put("numeroDcumento", mensaje.substring(5, 21).trim());
        parametros.put("referencia", mensaje.substring(21, 41).trim());
        parametros.put("monto", mensaje.substring(41, 56).trim());
        String fecha = mensaje.substring(56, 64).trim();
        Date date1 = new SimpleDateFormat("yyyyMMdd").parse(fecha);
        java.sql.Date sd = new java.sql.Date(date1.getTime());
        parametros.put("fecha", date1.toString());

        return parametros;
    }
}
