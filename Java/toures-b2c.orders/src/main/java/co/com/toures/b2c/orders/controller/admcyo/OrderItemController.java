package co.com.toures.b2c.orders.controller.admcyo;

import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.com.toures.b2c.orders.dto.admcyo.OrderItemDTO;
import co.com.toures.b2c.orders.dto.admcyo.SalesOrderDTO;
import co.com.toures.b2c.orders.model.admcyo.OrderItemRequest;
import co.com.toures.b2c.orders.service.OrderItemService;
import co.com.toures.b2c.orders.service.SalesOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api("Set of endpoints for retrieving orders")
public class OrderItemController {
	
	@Autowired
	private OrderItemService orderService;
	
	@Autowired
	private SalesOrderService salesService;
	
	
	@RequestMapping(method = RequestMethod.GET, value =  "/orderitem/{id}", produces = "application/json")
	@ApiOperation("Return all orders by id")
	public OrderItemDTO getOrderItemById(@PathVariable(value = "id") int idOrder)
	{
		return orderService.getOrderItemById(idOrder);
	}
	
	@RequestMapping(method = RequestMethod.POST, value =  "/orderitem/createOrder/", produces = "application/json")
	@ApiOperation("Create a new order")
	public String createOrder(@RequestBody OrderItemRequest orderRequest)
	{
		String retorno ="";
		String comment = "producto : "+ orderRequest.getProduct_name();
		int idSaleCreada;
		try {
			
			orderService.crearOrden(orderRequest.getProduct_cod(), orderRequest.getProduct_name(), orderRequest.getPrice(), orderRequest.getQuantity(), orderRequest.getOrder_id() );
			salesService.crearsaleOrder(orderRequest.getOrder_id(), orderRequest.getPrice(), comment, orderRequest.getIdcliente());
			//SalesOrderDTO sale = salesService.findLastCreated(orderRequest.getPrice(), comment, orderRequest.getIdcliente());
			
			
			 
			retorno = "OK";
		}catch(Exception e)
		{
			retorno= "Error crear orden";
		}
		
		return retorno;
	}
	
	

}
