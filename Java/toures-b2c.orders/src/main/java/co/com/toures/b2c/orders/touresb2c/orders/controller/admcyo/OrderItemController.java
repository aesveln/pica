package co.com.toures.b2c.orders.touresb2c.orders.controller.admcyo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.toures.b2c.orders.touresb2c.orders.dto.admcyo.OrderItemDTO;
import co.com.toures.b2c.orders.touresb2c.orders.model.admcyo.OrderItemRequest;
import co.com.toures.b2c.orders.touresb2c.orders.model.admcyo.OrderItemResponse;
import co.com.toures.b2c.orders.touresb2c.orders.service.OrderItemService;

@RestController
public class OrderItemController {

	@Autowired
	private OrderItemService orderItemService;
	
    ModelMapper modelMapper = new ModelMapper();
    
    
    @GetMapping("/orders/{id}")
	public OrderItemResponse getOrdersInfo(@RequestBody OrderItemRequest requestOrder)
	{
    	OrderItemDTO order = orderItemService.getOrderItemInfoById(requestOrder);
    	
    	OrderItemResponse resp = new OrderItemResponse();
    	resp = modelMapper.map(order, OrderItemResponse.class);
		return resp;
	}
}
