package co.com.toures.b2c.orders.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.toures.b2c.orders.dao.admcyo.OrderItemRepository;
import co.com.toures.b2c.orders.dto.admcyo.OrderItemDTO;
import co.com.toures.b2c.orders.entity.admcyo.OrderItem;

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
}