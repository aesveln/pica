package co.com.toures.b2c.orders.touresb2c.orders.dto.admcyo;

import java.math.BigDecimal;



public class OrderItemDTO {

	private BigDecimal id;
    private String productCod;
    private String productName;
    private Long price;
    private Integer quantity;
    private SalesOrderDTO orderId;
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
	public SalesOrderDTO getOrderId() {
		return orderId;
	}
	public void setOrderId(SalesOrderDTO orderId) {
		this.orderId = orderId;
	}
	
    
    
}
