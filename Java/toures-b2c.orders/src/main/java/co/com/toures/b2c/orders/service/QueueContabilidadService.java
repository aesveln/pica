package co.com.toures.b2c.orders.service;

import co.com.toures.b2c.orders.dao.admcyo.OrderItemRepository;
import co.com.toures.b2c.orders.dao.admcyo.SalesOrderRepository;
import co.com.toures.b2c.orders.dto.admcyo.OrderItemDTO;
import co.com.toures.b2c.orders.dto.admcyo.SalesOrderDTO;
import co.com.toures.b2c.orders.entity.admcyo.OrderItem;
import co.com.toures.b2c.orders.entity.admcyo.SalesOrder;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.commons.lang.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.jms.*;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class QueueContabilidadService {

    private ActiveMQConnectionFactory factory;
    private Connection con;
    private Session session;
    private Queue queue;

    public QueueContabilidadService() throws JMSException {
        factory = new ActiveMQConnectionFactory("fran", "fran", "tcp://localhost:61616");
        con = factory.createConnection();
        session = con.createSession(false, Session.DUPS_OK_ACKNOWLEDGE);
        queue = new ActiveMQQueue("jms/account/queue");
    }


    public void publicarMensajeFactura(SalesOrderDTO so) throws JMSException {

        String tipoMensaje = "001";
        String tipoDocumento = StringUtils.rightPad(so.getCustomerId().getDocumentType(), 3);
        String numeroDocumento = StringUtils.rightPad(so.getCustomerId().getDocumentNumber(), 15);
        String referencia = StringUtils.rightPad(so.getIdSales().toString(), 20);
        String monto = StringUtils.rightPad(so.getPrice().toString(), 15);
        String fecha = StringUtils.rightPad(so.getOrderDate().toString(), 8);
        String descripcion = StringUtils.rightPad(so.getComments(), 50);
        String cancelacion = "0";

        String msg = tipoMensaje + tipoDocumento + numeroDocumento + referencia + monto + fecha.replace("-", "") + descripcion + cancelacion;
        String msg2 = "002" + tipoDocumento + numeroDocumento + referencia + monto + fecha.replace("-", "") + StringUtils.rightPad("Prueba 002", 50) + cancelacion;
        String msg3 = "003" + tipoDocumento + numeroDocumento + referencia + monto + fecha.replace("-", "") + StringUtils.rightPad("Prueba 003", 50) + cancelacion;


        MessageProducer producer = session.createProducer(queue);
        TextMessage tm = session.createTextMessage(msg);
        TextMessage tm1 = session.createTextMessage(msg2);
        TextMessage tm2 = session.createTextMessage(msg3);
        producer.send(queue, tm);
        producer.send(queue, tm1);
        producer.send(queue, tm2);
        System.out.println("Mensaje enviado de factura : " +  msg );
        System.out.println("Mensaje enviado de factura : " +  msg2 );
        System.out.println("Mensaje enviado de factura : " +  msg3 );

    }

    public void publicarMensajeFacturaCancelacion(SalesOrderDTO so) throws JMSException {

        String tipoMensaje = "001";
        String tipoDocumento = StringUtils.rightPad(so.getCustomerId().getDocumentType(), 3);
        String numeroDocumento = StringUtils.rightPad(so.getCustomerId().getDocumentNumber(), 15);
        String referencia = StringUtils.rightPad(so.getIdSales().toString(), 20);
        String monto = StringUtils.rightPad(so.getPrice().toString(), 15);
        String fecha = StringUtils.rightPad(so.getOrderDate().toString(), 8);
        String descripcion = StringUtils.rightPad(so.getComments(), 50);
        String cancelacion = "1";

        String msg = tipoMensaje + tipoDocumento + numeroDocumento + referencia + monto + fecha.replace("-", "") + descripcion + cancelacion;
        String msg2 = "002" + tipoDocumento + numeroDocumento + referencia + monto + fecha.replace("-", "") + StringUtils.rightPad("Prueba 002", 50) + cancelacion;
        String msg3 = "003" + tipoDocumento + numeroDocumento + referencia + monto + fecha.replace("-", "") + StringUtils.rightPad("Prueba 003", 50) + cancelacion;


        MessageProducer producer = session.createProducer(queue);
        TextMessage tm = session.createTextMessage(msg);
        TextMessage tm1 = session.createTextMessage(msg2);
        TextMessage tm2 = session.createTextMessage(msg3);
        producer.send(queue, tm);
        producer.send(queue, tm1);
        producer.send(queue, tm2);
        System.out.println("Mensaje enviado de factura : " +  msg );
        System.out.println("Mensaje enviado de factura : " +  msg2 );
        System.out.println("Mensaje enviado de factura : " +  msg3 );

    }



}
