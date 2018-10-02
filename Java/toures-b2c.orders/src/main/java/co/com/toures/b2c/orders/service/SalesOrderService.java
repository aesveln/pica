package co.com.toures.b2c.orders.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
			SalesOrderDTO dto2 = new SalesOrderDTO(dto.getIdSales(), dto.getOrderDate(), dto.getPrice(),dto.getStatusOrder(), dto.getComments());
			
			DateFormat df = new SimpleDateFormat("dd/MM/YYYY");

			Date fecha = new Date(df.format(dto2.getOrderDate()));
			dto2.setOrderDate(fecha);
			
			salesDTOList.add(dto2);
		}
		
		
		return salesDTOList;
	}
	
	public int  cancelSales(int saleRequest)
	{
		SalesOrder sale = salesRepository.findSale(saleRequest);
		SalesOrderDTO dto = new SalesOrderDTO();
		modelmapper.map(sale, dto);
		
		if(dto.getStatusOrder().equals("RECH"))
		{
			return 0;
		}else {
			return salesRepository.cancelSaleOrder(dto.getIdSales().intValue());
		}
		
		
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
	
	public void crearsaleOrder (int idsale, long price, String comments, int customerid)
	{
		String error ="";
		try
		{
			salesRepository.createSaleOrder(idsale, price,  comments, customerid);	
		}catch(Exception e)
		{
			error = e.getMessage();
		}
		
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
