package co.com.toures.b2c.orders.touresb2c.orders.controller.admcyo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.toures.b2c.orders.touresb2c.orders.dto.admcyo.SalesOrderDTO;
import co.com.toures.b2c.orders.touresb2c.orders.model.admcyo.SalesOrderRequest;
import co.com.toures.b2c.orders.touresb2c.orders.model.admcyo.SalesOrderResponse;
import co.com.toures.b2c.orders.touresb2c.orders.service.SalesOrderService;

@RestController
public class SalesOrderController {

	@Autowired
	private SalesOrderService salesOrderService;
	
	 ModelMapper modelMapper = new ModelMapper();
	
	 @RequestMapping(method = RequestMethod.GET, value =  "/api/sales/bystatus")
	public SalesOrderResponse getOrderByStatus (@RequestBody SalesOrderRequest statusRequest)
	{
		SalesOrderDTO salesOrder = salesOrderService.getSaleOrderByStatus(statusRequest.toString());
		
		SalesOrderResponse salesResponse = new SalesOrderResponse();
		salesResponse = modelMapper.map(salesOrder, SalesOrderResponse.class);
		
		return salesResponse;
	}
}
