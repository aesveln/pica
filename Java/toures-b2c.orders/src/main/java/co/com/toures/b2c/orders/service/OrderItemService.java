package co.com.toures.b2c.orders.service;

import java.math.BigDecimal;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.toures.b2c.orders.dao.admcyo.OrderItemRepository;
import co.com.toures.b2c.orders.dto.admcyo.OrderItemDTO;
import co.com.toures.b2c.orders.entity.admcyo.OrderItem;
import co.com.toures.b2c.orders.model.admcyo.OrderItemRequest;

@Service
public class OrderItemService {

	@Autowired
	OrderItemRepository orderItemRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	
	public OrderItemDTO getOrderItemById (int orderRequest)
	{
		OrderItem order = orderItemRepository.findById(orderRequest);
		
		OrderItemDTO orderReturn = modelMapper.map(order, OrderItemDTO.class);
		
		return orderReturn;
	}
	
	public void crearOrden (int productcod, String productname, long price, int quantity, int idsale )
	{
		String error="";
		try
		{
			orderItemRepository.crearOrden(productcod, productname, price, quantity, idsale);
		}catch (Exception e)
		{
			error = e.getMessage();
			
		}
		
	}
}
