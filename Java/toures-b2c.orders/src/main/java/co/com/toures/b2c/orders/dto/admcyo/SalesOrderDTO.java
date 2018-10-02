package co.com.toures.b2c.orders.dto.admcyo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import co.com.toures.b2c.orders.entity.admcyo.Customer;
import co.com.toures.b2c.orders.entity.admcyo.OrderItem;


public class SalesOrderDTO {
	
	
    private BigDecimal idSales;
    private Date orderDate;
    private Long price;
    private String statusOrder;
    private String comments;
    private CustomerDTO customerId;
    private List<OrderItemDTO> orderItemList;
    
    
	public SalesOrderDTO() {
		
	}
	public SalesOrderDTO(BigDecimal idSales, Date orderDate, Long price, String statusOrder, String comments,
			CustomerDTO customerId, List<OrderItemDTO> orderItemList) {
		
		this.idSales = idSales;
		this.orderDate = orderDate;
		this.price = price;
		this.statusOrder = statusOrder;
		this.comments = comments;
		this.customerId = customerId;
		this.orderItemList = orderItemList;
	}
	public SalesOrderDTO(BigDecimal idSales, Date orderDate, Long price, String statusOrder, String comments) {
		this.idSales = idSales;
		this.orderDate = orderDate;
		this.price = price;
		this.statusOrder = statusOrder;
		this.comments = comments;
		
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
	public CustomerDTO getCustomerId() {
		return customerId;
	}
	public void setCustomerId(CustomerDTO customerId) {
		this.customerId = customerId;
	}
	public List<OrderItemDTO> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(List<OrderItemDTO> orderItemList) {
		this.orderItemList = orderItemList;
	}
    
    
}
