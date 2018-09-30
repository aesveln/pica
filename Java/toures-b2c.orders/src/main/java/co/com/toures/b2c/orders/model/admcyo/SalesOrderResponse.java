package co.com.toures.b2c.orders.model.admcyo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import co.com.toures.b2c.orders.dto.admcyo.OrderItemDTO;
import co.com.toures.b2c.orders.dto.admcyo.SalesOrderDTO;

public class SalesOrderResponse {

	
    private Page<OrderItemDTO> orderItemList;
    private List<SalesOrderDTO> sales;


    public SalesOrderResponse()
    {
    	
    }

	public Page<OrderItemDTO> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(Page<OrderItemDTO> orderItemList) {
		this.orderItemList = orderItemList;
	}

	public List<SalesOrderDTO> getSales() {
		return sales;
	}

	public void setSales(List<SalesOrderDTO> sales) {
		this.sales = sales;
	}
    
    

    
}
