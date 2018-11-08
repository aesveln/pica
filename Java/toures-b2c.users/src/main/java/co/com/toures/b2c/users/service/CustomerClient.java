package co.com.toures.b2c.users.service;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.namespace.QName;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import hello.Wsdl.Descuentoxcategoria;
import hello.Wsdl.DescuentoxcategoriaResponse;

 

@Component
public class CustomerClient extends WebServiceGatewaySupport{
	
	
	
	public double getRespuestaServicio (String categoria) throws DatatypeConfigurationException
	{
		WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
		double descuento = 0;
		Descuentoxcategoria cat = new Descuentoxcategoria();
		 JAXBElement<String> jaxbElement =
		  new JAXBElement(new QName("root-element"), 
		    String.class, categoria);
		 
		cat.setCategoria(jaxbElement);
        try {
        	final Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        	 marshaller.setContextPath("hello.Wsdl");
			 marshaller.afterPropertiesSet();
			 webServiceTemplate.setMarshaller(marshaller);
		     webServiceTemplate.afterPropertiesSet();
		        
			 webServiceTemplate.setUnmarshaller(marshaller);
			 setWebServiceTemplate(webServiceTemplate);
			DescuentoxcategoriaResponse resp = (DescuentoxcategoriaResponse) getWebServiceTemplate()
						.marshalSendAndReceive("http://localhost:4413/openl-tablets-ws-5.18.3/datasource/MotorReglas", 
								cat.getCategoria(),
								new SoapActionCallback(
										"document"));
			descuento = resp.getReturn().getValue();
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}

    	return descuento;

	}
}
