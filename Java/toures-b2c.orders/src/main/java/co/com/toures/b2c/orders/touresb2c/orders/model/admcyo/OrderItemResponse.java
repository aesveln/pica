package co.com.toures.b2c.orders.touresb2c.orders.model.admcyo;

import java.math.BigDecimal;

public class OrderItemResponse {

	private BigDecimal id;
	private BigDecimal productId;
	private String productName;
	private String partNum;
	private long price;
	private int quantity;
	private BigDecimal orderId;
	
	public OrderItemResponse(BigDecimal id, BigDecimal productId, String productName, String partNum, long price,
			int quantity, BigDecimal orderId) {
		
		this.id = id;
		this.productId = productId;
		this.productName = productName;
		this.partNum = partNum;
		this.price = price;
		this.quantity = quantity;
		this.orderId = orderId;
	}

	public OrderItemResponse() {
		
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPartNum() {
		return partNum;
	}

	public void setPartNum(String partNum) {
		this.partNum = partNum;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getOrderId() {
		return orderId;
	}

	public void setOrderId(BigDecimal orderId) {
		this.orderId = orderId;
	}
	
	
}
