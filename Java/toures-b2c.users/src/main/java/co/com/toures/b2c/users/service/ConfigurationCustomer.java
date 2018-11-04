package co.com.toures.b2c.users.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ConfigurationCustomer {
	
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("co.com.toures.b2c.motorReglas.wsdl");
		return marshaller;
	}
	
	
	public CustomerClient customerConfClient(Jaxb2Marshaller marshaller) {
		CustomerClient client = new CustomerClient();
		client.setDefaultUri("http://localhost:4413/openl-tablets-ws-5.18.3/datasource/MotorReglas");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
