package co.com.toures.b2c.orders.service;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;



public class SalesOrderClient extends WebServiceGatewaySupport{

	public String getRespuestaServicio (int id)
	{
		String response = (String) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8088/Creation", id,
						new SoapActionCallback(
								"Creation"));
		
		return response;

	}
}
