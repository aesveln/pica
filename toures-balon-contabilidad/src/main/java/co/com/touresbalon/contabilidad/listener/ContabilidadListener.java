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

    @JmsListener(destination = "jms/account/queue")
    public void onMessage(final Message message) throws JMSException, IOException {

        System.out.println("Nuevo mensaje recibido:");
        TextMessage tm = (TextMessage) message;
        System.out.println(tm.getText());

        String tipoMensaje = tm.getText().substring(0, 3);
        FileWriter writer;
        BufferedWriter bw;
        switch (tipoMensaje) {

            case "001":
                writer = new FileWriter("/home/narfco/Software/contabilidad/001.flf", true);
                bw = new BufferedWriter(writer);
                bw.append(tm.getText());
                bw.newLine();
                bw.close();
                break;
            case "002":
                writer = new FileWriter("/home/narfco/Software/contabilidad/002.flf", true);
                bw = new BufferedWriter(writer);
                bw.append(tm.getText());
                bw.newLine();
                bw.close();
                break;
            case "003":
                writer = new FileWriter("/home/narfco/Software/contabilidad/003.flf", true);
                bw = new BufferedWriter(writer);
                bw.append(tm.getText());
                bw.newLine();
                bw.close();

                break;
        }


    }
}
