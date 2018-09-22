package co.com.toures.b2c.orders.controller.admcyo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.toures.b2c.orders.dto.admcyo.SalesOrderDTO;
import co.com.toures.b2c.orders.model.admcyo.SalesOrderRequest;
import co.com.toures.b2c.orders.service.SalesOrderService;

//import prueba3.wsdl.GetCountryRequest;
//import prueba3.wsdl.GetCountryResponse;

@RestController
public class SalesOrderController {

	@Autowired
	private SalesOrderService salesService;
	
	ModelMapper modelMapper = new ModelMapper();
	
	@GetMapping("/salesorder/{status}")
	public List<SalesOrderDTO> getSalesByStatus (@PathVariable(value = "status") String status)
	{
		return salesService.findSalesByStatus(status);
	}
	
	@GetMapping("/salesorderOpen")
	public List<SalesOrderDTO> getSalesOpen ()
	{
		return salesService.findOpenSales();
	}
	
	@RequestMapping(method = RequestMethod.GET, value =  "/salesorder/cancelSaleOrder/{idsales}")
	public int cancelSale  (@PathVariable(value = "idsales") int idsales)
	{
		return salesService.cancelSales(idsales);
	}
	
	@RequestMapping(method = RequestMethod.GET, value =  "/salesorder/salesCliente/{idcliente}")
	public List<SalesOrderDTO> getSalesforClient (@PathVariable(value = "idcliente") int idcliente)
	{
		return salesService.ordenesClientes(idcliente);
	}
}
