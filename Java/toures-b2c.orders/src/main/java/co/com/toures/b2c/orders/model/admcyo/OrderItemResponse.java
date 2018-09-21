package co.com.toures.b2c.orders.model.admcyo;

import java.math.BigDecimal;

import co.com.toures.b2c.orders.entity.admcyo.SalesOrder;

public class OrderItemResponse {

	private BigDecimal id;
    private String productCod;
    private String productName;
    private Long price;
    private Integer quantity;
    private SalesOrder orderId;
    
    public OrderItemResponse()
    {
    	
    }

	public OrderItemResponse(BigDecimal id, String productCod, String productName, Long price, Integer quantity,
			SalesOrder orderId) {
		super();
		this.id = id;
		this.productCod = productCod;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.orderId = orderId;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getProductCod() {
		return productCod;
	}

	public void setProductCod(String productCod) {
		this.productCod = productCod;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public SalesOrder getOrderId() {
		return orderId;
	}

	public void setOrderId(SalesOrder orderId) {
		this.orderId = orderId;
	}
    
    
}
