package co.com.toures.b2c.orders.touresb2c.orders.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.toures.b2c.orders.touresb2c.orders.dao.admcyo.OrderItemRepository;
import co.com.toures.b2c.orders.touresb2c.orders.dto.admcyo.OrderItemDTO;
import co.com.toures.b2c.orders.touresb2c.orders.entity.admcyo.OrderItem;
import co.com.toures.b2c.orders.touresb2c.orders.model.admcyo.OrderItemRequest;

@Service
public class OrderItemService {

	@Autowired
	OrderItemRepository orderItemRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	
	public OrderItemDTO getOrderItemInfoById (OrderItemRequest orderRequest)
	{
		OrderItem orderItemEntity = orderItemRepository.findById(orderRequest.getId()).orElse(null);
		
		OrderItemDTO orderDTO = modelMapper.map(orderItemEntity,OrderItemDTO.class);
		
		return orderDTO;
	}
}
