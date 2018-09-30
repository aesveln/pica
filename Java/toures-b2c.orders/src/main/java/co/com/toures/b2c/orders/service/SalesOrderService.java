package co.com.toures.b2c.orders.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import co.com.toures.b2c.orders.dao.admcyo.OrderItemRepository;
import co.com.toures.b2c.orders.dao.admcyo.SalesOrderRepository;
import co.com.toures.b2c.orders.dto.admcyo.CustomerDTO;
import co.com.toures.b2c.orders.dto.admcyo.OrderItemDTO;
import co.com.toures.b2c.orders.dto.admcyo.SalesOrderDTO;
import co.com.toures.b2c.orders.entity.admcyo.OrderItem;
import co.com.toures.b2c.orders.entity.admcyo.SalesOrder;
import co.com.toures.b2c.orders.model.admcyo.SalesOrderRequest;

@Service
public class SalesOrderService {
	
	@Autowired
	SalesOrderRepository salesRepository;
	ModelMapper modelmapper = new ModelMapper();
	
	@Autowired
	SalesOrderClient salesSoap = new SalesOrderClient();
	@Autowired
	OrderItemRepository orderItemRepository;
	
	
	
	public List<SalesOrderDTO> findSalesByStatus (String status)
	{
		Pageable pageable = PageRequest.of(0, 10);
		List<SalesOrder> sales = salesRepository.findBystatusOrder(status, pageable);
		
		List<SalesOrderDTO> salesDTOList = new ArrayList<SalesOrderDTO>();
		
		for(SalesOrder s: sales)
		{
			SalesOrderDTO dto = new SalesOrderDTO();
			modelmapper.map(s, dto);
			salesDTOList.add(dto);
		}
		
		
		return salesDTOList;
	}
	
	public List<SalesOrderDTO> findOpenSales (int idcliente) 
	{
		Pageable pageable = PageRequest.of(0, 10);
		
		List<SalesOrderDTO> salesDTOList = new ArrayList<SalesOrderDTO>();
		
		List<SalesOrder> sales =  salesRepository.findOpenSales(idcliente, pageable);
		
		
		for(SalesOrder s: sales)
		{
		
			SalesOrderDTO dto = new SalesOrderDTO();
					modelmapper.map(s, dto);
			Date fecha = new java.util.Date(dto.getOrderDate().getTime());
			dto.setOrderDate(fecha);
			dto.getOrderItemList().removeAll(dto.getOrderItemList());
			dto.setCustomerId(null);
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
			SalesOrderDTO dto = new SalesOrderDTO();
			modelmapper.map(s, dto);
			salesDTOList.add(dto);
		}
		
		return salesDTOList;
	}
	
	
	public String getRespuestaServicioAvianca (int id)
	{
		return salesSoap.getRespuestaServicio(id);
	}
	
	public void crearsaleOrder (long price, String comments, int customerid)
	{
		salesRepository.createSaleOrder(price, comments, customerid);
	}
	
	public List<OrderItemDTO> detalleOrderItem (int idsales)
	{
		Pageable pageable = PageRequest.of(0, 10);
		List<OrderItem> orders =  orderItemRepository.detalleOrdenes(idsales, pageable);
		
		List<OrderItemDTO> dtos = new ArrayList<OrderItemDTO>();
		
		for(OrderItem s: orders)
		{
			OrderItemDTO dto = new OrderItemDTO();
			modelmapper.map(s, dto);
			dtos.add(dto);
		}
		
		return dtos;
		
	}
}
