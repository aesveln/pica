package co.com.toures.b2c.orders.entity.admcyo;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "ADMCYO", name = "SALES_ORDER")
@Getter
@Setter
public class SalesOrder {
	
	@Id
    @Basic(optional = false)
    @Column(name = "ID_SALES")
    private BigDecimal idSales;
    @Column(name = "ORDER_DATE")
    private Date orderDate;
    @Column(name = "PRICE")
    private Long price;
    @Column(name = "STATUS_ORDER")
    private String statusOrder;
    @Column(name = "COMMENTS")
    private String comments;
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID_CUSTOMER")
    @ManyToOne(optional = false)
    @JsonIgnore
    private Customer customerId;
    @OneToMany(mappedBy = "orderId")
    @JsonIgnore
    private List<OrderItem> orderItemList;
    
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
	public Customer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}
	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}

    
}
