package co.com.toures.b2c.orders.touresb2c.orders.model.admcyo;

import java.math.BigDecimal;

public class OrderItemRequest {

	private BigDecimal id;
	private BigDecimal productId;
	
	
	public OrderItemRequest() {
		
	}


	public BigDecimal getId() {
		return id;
	}


	public void setId(BigDecimal id) {
		this.id = id;
	}


	public BigDecimal getProductId() {
		return productId;
	}


	public void setProductId(BigDecimal productId) {
		this.productId = productId;
	}
	
	
	
	
}
