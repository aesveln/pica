package co.com.toures.b2c.orders.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import co.com.toures.b2c.orders.dao.admcyo.SalesOrderRepository;
import co.com.toures.b2c.orders.dto.admcyo.SalesOrderDTO;
import co.com.toures.b2c.orders.entity.admcyo.SalesOrder;
import co.com.toures.b2c.orders.model.admcyo.SalesOrderRequest;

@Service
public class SalesOrderService {
	
	@Autowired
	SalesOrderRepository salesRepository;
	
	ModelMapper modelmapper = new ModelMapper();
	
	public List<SalesOrderDTO> findSalesByStatus (String status)
	{
		Pageable pageable = PageRequest.of(0, 10);
		List<SalesOrder> sales = salesRepository.findBystatusOrder(status, pageable);
		
		List<SalesOrderDTO> salesDTOList = new ArrayList<SalesOrderDTO>();
		
		for(SalesOrder s: sales)
		{
			SalesOrderDTO dto = modelmapper.map(s, SalesOrderDTO.class);
			salesDTOList.add(dto);
		}
		
		
		return salesDTOList;
	}
	
	public List<SalesOrderDTO> findOpenSales ()
	{
		Pageable pageable = PageRequest.of(0, 10);
		List<SalesOrder> sales =  salesRepository.findOpenSales(pageable);
		
		List<SalesOrderDTO> salesDTOList = new ArrayList<SalesOrderDTO>();
		
		
		for(SalesOrder s: sales)
		{
			SalesOrderDTO dto = modelmapper.map(s, SalesOrderDTO.class);
			salesDTOList.add(dto);
		}
		
		return salesDTOList;
	}
	
	public int  cancelSales(int saleRequest)
	{
		return salesRepository.cancelSaleOrder(saleRequest);
		
	}
	
	public List<SalesOrderDTO> ordenesClientes(int idcliente)
	{
		Pageable pageable = PageRequest.of(0, 10);
		List<SalesOrder> sales =  salesRepository.ordenesCliente(idcliente, pageable);
		
		List<SalesOrderDTO> salesDTOList = new ArrayList<SalesOrderDTO>();
		
		for(SalesOrder s: sales)
		{
			SalesOrderDTO salesDTO = modelmapper.map(s, SalesOrderDTO.class);
			salesDTOList.add(salesDTO);
		}
		
		return salesDTOList;
	}

}
