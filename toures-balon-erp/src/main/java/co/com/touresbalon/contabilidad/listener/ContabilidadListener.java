package co.com.touresbalon.contabilidad.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class ContabilidadListener {

    @JmsListener(destination = "jms/erp/queue")
    public void onMessage(final Message message) throws JMSException, IOException {

        System.out.println("Nuevo mensaje recibido en el erp:");
        TextMessage tm = (TextMessage) message;
        System.out.println(tm.getText());



    }
}
