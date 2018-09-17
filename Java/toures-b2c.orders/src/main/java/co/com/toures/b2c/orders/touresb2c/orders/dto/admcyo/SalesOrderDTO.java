package co.com.toures.b2c.orders.touresb2c.orders.dto.admcyo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;



public class SalesOrderDTO {

	private BigDecimal idSales;
    private Date orderDate;
    private Long price;
    private String statusOrder;
    private String comments;
    private List<OrderItemDTO> orderItemList;
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
