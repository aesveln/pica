package co.com.toures.b2c.orders.controller.admcyo;

import java.io.File;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import javax.xml.ws.Endpoint;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import co.com.toures.b2c.orders.dto.admcyo.SalesOrderDTO;
import co.com.toures.b2c.orders.entity.admcyo.OrderItem;
import co.com.toures.b2c.orders.model.admcyo.OrderItemRequest;
import co.com.toures.b2c.orders.model.admcyo.OrderItemResponse;
import co.com.toures.b2c.orders.model.admcyo.SalesOrderRequest;
import co.com.toures.b2c.orders.model.admcyo.SalesOrderResponse;
import co.com.toures.b2c.orders.service.SalesOrderClient;
import co.com.toures.b2c.orders.service.SalesOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api("Set of endpoints for retrieving salesOrders")
public class SalesOrderController {

	@Autowired
	private SalesOrderService salesService;
	
	ModelMapper modelMapper = new ModelMapper();
	
	
	static final String URL_HOTELES = "http://localhost:8087/HotelDann";
	static final String URL_EVENTO = "http://localhost:8087/TuBoleta";
	
	@RequestMapping(method = RequestMethod.POST, value =  "/salesorder/salesOrderStatus", produces = "application/json")
	@ApiOperation("Return all sales by status")
	public  ResponseEntity <SalesOrderResponse> getSalesByStatus (@RequestBody SalesOrderRequest saleRequest)
	{
		SalesOrderResponse response = new SalesOrderResponse();
		
		response.setSales( salesService.findSalesByStatus(saleRequest.getStatus()));
		
		return ResponseEntity.ok(response);
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value =  "/salesorder/salesorderOpen/", produces = "application/json")
	@ApiOperation("Return all sales open")
	public ResponseEntity <SalesOrderResponse> getSalesOpen (@RequestBody SalesOrderRequest saleRequest)
	{
		SalesOrderResponse response = new SalesOrderResponse();
		response.setSales(salesService.findOpenSales(saleRequest.getIdcustomer().intValue()));
		return ResponseEntity.ok(response);
	}
	
	@RequestMapping(method = RequestMethod.POST, value =  "/salesorder/cancelSaleOrder/", produces = "application/json")
	@ApiOperation("cancel a sale")
	public String cancelSale  (@RequestBody SalesOrderRequest salerequest)
	{
		 RestTemplate restTemplate = new RestTemplate();
		 int salecancel;
		 String ret="";
		 File bolivariano = new File("CanceladasBolivariano.txt");
		 File hilton = new File("CanceladasHilton.txt");
		 
		 try
		 {
			 
			 if(!bolivariano.exists())
			 {
				 bolivariano.createNewFile();
			 }
			 
			 if(!hilton.exists())
			 {
				 hilton.createNewFile();
			 }
			 
			 PrintWriter pw = new PrintWriter (bolivariano);
			 pw.println("Se cancela reserva del cliente: "+ salerequest.getId() );
			 pw.close();
			 
			 PrintWriter pw2 = new PrintWriter (hilton);
			 pw2.println("Se cancela reserva del cliente: "+ salerequest.getId());
			 pw2.close();
			 
			//POST METHOD
			 String resultHoteles = restTemplate.postForObject(URL_HOTELES, salerequest.getId() ,String.class);
			 String resultEvento = restTemplate.postForObject(URL_EVENTO, salerequest.getId() ,String.class);
			
			 //Servicios SOAP
			 String respSOAPAmerican = salesService.getRespuestaServicioAvianca(salerequest.getId().intValue());
			 salecancel = salesService.cancelSales(salerequest.getId().intValue());
			
				 ret = "Orden cancelada";
			
		 }catch(Exception e)
		 {
			 ret="Error "+ e.getMessage();
		 }
		
		 	 
		 return ret;
	}
	
	@RequestMapping(method = RequestMethod.POST, value =  "/salesorder/salesCliente/", produces = "application/json")
	@ApiOperation("Return all sales by client id")
	public ResponseEntity <SalesOrderResponse> getSalesforClient (@RequestBody SalesOrderRequest saleRequest)
	{
		SalesOrderResponse response = new SalesOrderResponse();
		response.setSales(salesService.ordenesClientes(saleRequest.getIdcustomer().intValue()));
		return ResponseEntity.ok(response);		
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value =  "/salesorder/detallesOrders", produces = "application/json")
	@ApiOperation("Return all order items for a sale")
	public  ResponseEntity <OrderItemResponse> getDetalleOrder (@RequestBody OrderItemRequest orderRequest)
	{
		OrderItemResponse response = new OrderItemResponse();
		
		response.setListOrdenes(salesService.detalleOrderItem(orderRequest.getIdsale()));
		
		return ResponseEntity.ok(response);
		
	}
}
