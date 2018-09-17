package co.com.toures.b2c.orders.touresb2c.orders.model.admcyo;

import java.math.BigDecimal;

public class SalesOrderRequest {

	private BigDecimal id;
	private String status;
	
	public SalesOrderRequest()
	{
		
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
