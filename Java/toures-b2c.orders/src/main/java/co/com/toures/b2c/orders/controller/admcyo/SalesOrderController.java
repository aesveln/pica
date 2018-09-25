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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import co.com.toures.b2c.orders.dto.admcyo.SalesOrderDTO;
import co.com.toures.b2c.orders.model.admcyo.SalesOrderRequest;
import co.com.toures.b2c.orders.model.admcyo.SalesOrderResponse;
import co.com.toures.b2c.orders.service.SalesOrderService;

//import prueba3.wsdl.GetCountryRequest;
//import prueba3.wsdl.GetCountryResponse;

@RestController
public class SalesOrderController {

	@Autowired
	private SalesOrderService salesService;
	
	ModelMapper modelMapper = new ModelMapper();
	
	
	static final String URL_HOTELES = "http://localhost:8087/HotelDann";
	static final String URL_EVENTO = "http://localhost:8087/TuBoleta";
	
	@GetMapping("/salesorder/{status}")
	public SalesOrderResponse getSalesByStatus (@PathVariable(value = "status") String status)
	{
		SalesOrderResponse response = new SalesOrderResponse();
		
		response.setSales( salesService.findSalesByStatus(status));
		
		return response;
	}
	
	@GetMapping("/salesorderOpen")
	public List<SalesOrderDTO> getSalesOpen ()
	{
		return salesService.findOpenSales();
	}
	
	@RequestMapping(method = RequestMethod.GET, value =  "/salesorder/cancelSaleOrder/{idsales}")
	public String cancelSale  (@PathVariable(value = "idsales") int idsales)
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
			 pw.println("Se cancela reserva del cliente: "+idsales);
			 pw.close();
			 
			 PrintWriter pw2 = new PrintWriter (hilton);
			 pw2.println("Se cancela reserva del cliente: "+idsales);
			 pw2.close();
			 
			//POST METHOD
			 String resultHoteles = restTemplate.postForObject(URL_HOTELES, idsales ,String.class);
			 String resultEvento = restTemplate.postForObject(URL_EVENTO, idsales ,String.class);
			
			 salecancel = salesService.cancelSales(idsales);
			
				 ret = "Orden cancelada";
			
		 }catch(Exception e)
		 {
			 ret="Se re puteo "+ e.getMessage();
		 }
		
		 	 
		 return ret;
	}
	
	@RequestMapping(method = RequestMethod.GET, value =  "/salesorder/salesCliente/{idcliente}")
	public List<SalesOrderDTO> getSalesforClient (@PathVariable(value = "idcliente") int idcliente)
	{
		
		return salesService.ordenesClientes(idcliente);
	}
}
