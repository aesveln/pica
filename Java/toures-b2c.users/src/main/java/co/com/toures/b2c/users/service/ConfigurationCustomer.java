package co.com.toures.b2c.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.transport.http.HttpsUrlConnectionMessageSender;

@Configuration
public class ConfigurationCustomer {
	
	
	
	@Bean
	public Jaxb2Marshaller marshaller() {
		final Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPaths("hello.Wsdl");
		return marshaller;
	}
	
	
	public CustomerClient customerConfClient(Jaxb2Marshaller marshaller) {
		CustomerClient client = new CustomerClient();
		client.setDefaultUri("");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);

		final HttpsUrlConnectionMessageSender messageSender = new HttpsUrlConnectionMessageSender();

		messageSender.setHostnameVerifier((hostname, sslSession) -> {
			if (hostname.equals("localhost")) {
				return true;
			}
			return true;
		});

		client.setMessageSender(messageSender);

		return client;

	}

}
