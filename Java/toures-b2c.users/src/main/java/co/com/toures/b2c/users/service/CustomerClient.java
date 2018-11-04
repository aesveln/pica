package co.com.toures.b2c.users.service;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Component
public class CustomerClient extends WebServiceGatewaySupport{

	public double getRespuestaServicio (String categoria)
	{
		WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
		
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		String response = "";
       
        try {
        	 marshaller.setContextPath("co.com.toures.b2c.motorReglas.wsdl");
			 marshaller.afterPropertiesSet();
			 webServiceTemplate.setMarshaller(marshaller);
		     webServiceTemplate.afterPropertiesSet();
		        
			 webServiceTemplate.setMarshaller(marshaller);
			 webServiceTemplate.setUnmarshaller(marshaller);
			 response =	 (String) getWebServiceTemplate()
						.marshalSendAndReceive("http://localhost:4413/openl-tablets-ws-5.18.3/datasource/MotorReglas?wsdl", categoria,
								new SoapActionCallback(
										"http://localhost:4413/openl-tablets-ws-5.18.3/datasource/MotorReglas"));
			
		} catch (Exception e) {
			
			response = e.getMessage();
		}

    	return Double.parseDouble(response);

	}
}
