package co.edu.javeriana.middleware.composition.controllers;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import co.edu.javeriana.foundation.middleware.controller.IntegrationController;

@Component
public class ComposicionPocSmsController extends IntegrationController {

	private static final String SOURCE_BODY = "source-body";
	private static Logger LOGGER = LoggerFactory.getLogger(ComposicionPocSmsController.class);

	public ComposicionPocSmsController() {
		super();
	}

	public void salvarEstado(final Exchange exchange) {
		Object body = exchange.getIn().getBody();
		LOGGER.info("salvando copia del mensaje canonico original: {}", body);
		putContextAttribute(exchange, SOURCE_BODY, body);
	}
	
	public void recuperarEstado(final Exchange exchange) {
		LOGGER.info("recuperando copia del mensaje canonico original: {}", getContextAttribute(exchange, SOURCE_BODY) );
	}

}
