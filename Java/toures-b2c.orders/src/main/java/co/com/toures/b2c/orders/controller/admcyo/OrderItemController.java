package co.com.toures.b2c.orders.controller.admcyo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.com.toures.b2c.orders.dto.admcyo.OrderItemDTO;
import co.com.toures.b2c.orders.service.OrderItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api("Set of endpoints for retrieving orders")
public class OrderItemController {
	
	@Autowired
	private OrderItemService orderService;
	
	
	@RequestMapping(method = RequestMethod.GET, value =  "/orderitem/{id}")
	@ApiOperation("Return all orders by id")
	public OrderItemDTO getOrderItemById(@PathVariable(value = "id") int idOrder)
	{
		return orderService.getOrderItemById(idOrder);
	}

}
