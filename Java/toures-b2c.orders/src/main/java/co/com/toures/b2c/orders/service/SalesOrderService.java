package co.com.toures.b2c.orders.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import co.com.toures.b2c.orders.dao.admcyo.SalesOrderRepository;
import co.com.toures.b2c.orders.dto.admcyo.SalesOrderDTO;
import co.com.toures.b2c.orders.entity.admcyo.SalesOrder;
import co.com.toures.b2c.orders.model.admcyo.SalesOrderRequest;

public class SalesOrderService {
	
	@Autowired
	SalesOrderRepository salesRepository;
	
	ModelMapper modelmapper = new ModelMapper();
	
	public List<SalesOrderDTO> findSalesByStatus (String status)
	{
		List<SalesOrder> sales = salesRepository.findBystatusOrder(status);
		
		List<SalesOrderDTO> salesDTOList = new ArrayList<SalesOrderDTO>();
		
		for(SalesOrder s: sales)
		{
			SalesOrderDTO salesDTO = modelmapper.map(s, SalesOrderDTO.class);
			salesDTOList.add(salesDTO);
		}
		
		return salesDTOList;
	}
	
	public List<SalesOrderDTO> findOpenSales ()
	{
		List<SalesOrder> sales =  salesRepository.findOpenSales();
		
		List<SalesOrderDTO> salesDTOList = new ArrayList<SalesOrderDTO>();
		
		for(SalesOrder s: sales)
		{
			SalesOrderDTO salesDTO = modelmapper.map(s, SalesOrderDTO.class);
			salesDTOList.add(salesDTO);
		}
		
		return salesDTOList;
	}
	
	public void cancelSales(SalesOrderRequest saleRequest)
	{
		salesRepository.cancelSaleOrder(saleRequest.getId().intValue());
	}

}
