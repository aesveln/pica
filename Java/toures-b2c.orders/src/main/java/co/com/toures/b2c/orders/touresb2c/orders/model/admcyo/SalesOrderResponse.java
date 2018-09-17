package co.com.toures.b2c.orders.touresb2c.orders.model.admcyo;

import java.math.BigDecimal;
import java.util.Date;

public class SalesOrderResponse {

	private BigDecimal id;
	private Date orderDate;
	private long price;
	private String status;
	private String comments;
	private String custNumber;
	private String custDocumenType;
	
	public SalesOrderResponse()
	{
		
	}

	public SalesOrderResponse(BigDecimal id, Date orderDate, long price, String status, String comments,
			String custNumber, String custDocumenType) {
		this.id = id;
		this.orderDate = orderDate;
		this.price = price;
		this.status = status;
		this.comments = comments;
		this.custNumber = custNumber;
		this.custDocumenType = custDocumenType;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getCustNumber() {
		return custNumber;
	}

	public void setCustNumber(String custNumber) {
		this.custNumber = custNumber;
	}

	public String getCustDocumenType() {
		return custDocumenType;
	}

	public void setCustDocumenType(String custDocumenType) {
		this.custDocumenType = custDocumenType;
	}
	
	
	
	
}
