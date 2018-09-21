package co.com.toures.b2c.orders.model.admcyo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import co.com.toures.b2c.orders.dto.admcyo.OrderItemDTO;

public class SalesOrderResponse {

	private BigDecimal idSales;
    private Date orderDate;
    private Long price;
    private String statusOrder;
    private String comments;
    private List<OrderItemDTO> orderItemList;
    
    public SalesOrderResponse()
    {
    	
    }

	public SalesOrderResponse(BigDecimal idSales, Date orderDate, Long price, String statusOrder, String comments,
			List<OrderItemDTO> orderItemList) {
		super();
		this.idSales = idSales;
		this.orderDate = orderDate;
		this.price = price;
		this.statusOrder = statusOrder;
		this.comments = comments;
		this.orderItemList = orderItemList;
	}

	public BigDecimal getIdSales() {
		return idSales;
	}

	public void setIdSales(BigDecimal idSales) {
		this.idSales = idSales;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getStatusOrder() {
		return statusOrder;
	}

	public void setStatusOrder(String statusOrder) {
		this.statusOrder = statusOrder;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public List<OrderItemDTO> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(List<OrderItemDTO> orderItemList) {
		this.orderItemList = orderItemList;
	}
    
    
}
