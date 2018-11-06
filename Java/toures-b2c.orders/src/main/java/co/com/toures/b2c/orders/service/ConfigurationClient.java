package co.com.toures.b2c.orders.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ConfigurationClient {
	
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("co.com.toures.b2c.orders.wsdl");
		return marshaller;
	}


	public SalesOrderClient salesOrderClient(Jaxb2Marshaller marshaller) {
		SalesOrderClient client = new SalesOrderClient();
		client.setDefaultUri("http://192.168.1.100:8088/Creation");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
