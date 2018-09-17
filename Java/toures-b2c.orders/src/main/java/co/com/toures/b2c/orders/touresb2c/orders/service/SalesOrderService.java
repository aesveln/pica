package co.com.toures.b2c.orders.touresb2c.orders.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.toures.b2c.orders.touresb2c.orders.dao.admcyo.SalesOrderRepository;
import co.com.toures.b2c.orders.touresb2c.orders.dto.admcyo.SalesOrderDTO;
import co.com.toures.b2c.orders.touresb2c.orders.entity.admcyo.SalesOrder;
import co.com.toures.b2c.orders.touresb2c.orders.model.admcyo.SalesOrderRequest;

@Service
public class SalesOrderService {

	@Autowired
	SalesOrderRepository salesOrderRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	
	public SalesOrderDTO getSaleOrderInfoById (SalesOrderRequest sale)
	{
		SalesOrder salesEntity = salesOrderRepository.findById(sale.getId()).orElse(null);
		
		SalesOrderDTO salesDto = modelMapper.map(salesEntity, SalesOrderDTO.class);
		
		return salesDto;
	}
}
