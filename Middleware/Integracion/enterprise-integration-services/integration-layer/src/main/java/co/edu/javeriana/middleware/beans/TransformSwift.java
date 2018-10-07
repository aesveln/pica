package co.edu.javeriana.middleware.beans;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;

public class TransformSwift {


    public String trnsformToJsonSWIFT(String msg) {


        try {
            XmlMapper xmlMapper = new XmlMapper();

            JsonNode jsonNode = xmlMapper.readTree(msg.getBytes());

            ObjectMapper objectMapper = new ObjectMapper();

            String value = objectMapper.writeValueAsString(jsonNode);

            System.out.println("*** Converting XML to JSON ***");
            System.out.println(value);


        } catch (
                JsonParseException e) {
            e.printStackTrace();
        } catch (
                JsonMappingException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return msg;

    }

}
