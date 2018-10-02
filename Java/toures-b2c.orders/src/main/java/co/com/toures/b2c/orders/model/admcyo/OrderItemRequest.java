package co.com.toures.b2c.orders.model.admcyo;

import java.math.BigDecimal;

public class OrderItemRequest {
	
	private int order_id;
	private int product_cod;
	private String product_name;
	private long price;
	private int quantity;
	private int idcliente;
	
	public OrderItemRequest()
	{
		
	}

	public OrderItemRequest(BigDecimal id, BigDecimal order_id) {
		
	}


	public int getProduct_cod() {
		return product_cod;
	}

	public void setProduct_cod(int product_cod) {
		this.product_cod = product_cod;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
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

	
	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	
	
}
