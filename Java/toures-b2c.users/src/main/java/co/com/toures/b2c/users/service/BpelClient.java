package co.com.toures.b2c.users.service;


import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import validarTarjeta.wsdl.SalesOrderBPELRequest;
import validarTarjeta.wsdl.SalesOrderBPELResponse;


@Component
public class BpelClient extends WebServiceGatewaySupport{
	

    private String hostname = "http://localhost:7101";

	
	private String callbackHostname = "http://localhost:7101"; 
	
	private String endpoint = "/soa-infra/services/default/ValidacionTarjetaCredito/bpelvalidartc_client_ep/" ;

	
	@SuppressWarnings("unchecked")
	public boolean getConnection(String request) {

		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
		boolean resultadoSOAP = false;
		SalesOrderBPELRequest req = new SalesOrderBPELRequest();
		req.setTarjeta(request);
		
		 try {
			 marshaller.setContextPath("validarTarjeta.wsdl");
			marshaller.afterPropertiesSet();
			 webServiceTemplate.setMarshaller(marshaller);
		     webServiceTemplate.afterPropertiesSet();
		        
			 webServiceTemplate.setUnmarshaller(marshaller);
			 
			 setWebServiceTemplate(webServiceTemplate);

			 SalesOrderBPELResponse resp  =
						 
						(SalesOrderBPELResponse) getWebServiceTemplate().marshalSendAndReceive(
					"http://localhost:7101/soa-infra/services/default/ValidacionTarjetaCredito/bpelvalidartc_client_ep", req,
			new SoapActionCallback(
					"process"));
		
			 resultadoSOAP = resp.isTarjetaValida(); 
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
			

		return resultadoSOAP;
	}


	
	

}
