package co.com.toures.b2c.orders.service;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Component
public class SalesOrderClient extends WebServiceGatewaySupport{

	public String getRespuestaServicio (int id)
	{
		WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
		
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		String response = "";
       
        try {
        	 marshaller.setContextPath("co.com.toures.b2c.orders.wsdl");
			 marshaller.afterPropertiesSet();
			 webServiceTemplate.setMarshaller(marshaller);
		     webServiceTemplate.afterPropertiesSet();
		        
			 webServiceTemplate.setMarshaller(marshaller);
			 webServiceTemplate.setUnmarshaller(marshaller);
			 response = (String) getWebServiceTemplate()
						.marshalSendAndReceive("http://192.168.1.100:8088/mockServiceAmerican?WSDL", id,
								new SoapActionCallback(
										"http://192.168.1.100:8088/mockServiceAvianca"));
			
		} catch (Exception e) {
			
			response = e.getMessage();
		}

    	return response;

	}
}
