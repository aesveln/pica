package co.com.toures.b2c.orders.model.admcyo;

import java.math.BigDecimal;

public class OrderItemRequest {
	
	private BigDecimal id;
	private BigDecimal order_id;
	
	public OrderItemRequest()
	{
		
	}

	public OrderItemRequest(BigDecimal id, BigDecimal order_id) {
		super();
		this.id = id;
		this.order_id = order_id;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public BigDecimal getOrder_id() {
		return order_id;
	}

	public void setOrder_id(BigDecimal order_id) {
		this.order_id = order_id;
	}

	
}
