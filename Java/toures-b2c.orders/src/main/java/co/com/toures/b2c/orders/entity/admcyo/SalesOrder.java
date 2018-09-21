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
    private int idSales;
    @Column(name = "ORDER_DATE")
    private Date orderDate;
    @Column(name = "PRICE")
    private Long price;
    @Column(name = "STATUS_ORDER")
    private String statusOrder;
    @Column(name = "COMMENTS")
    private String comments;
    @OneToMany(mappedBy = "orderId")
    @JsonIgnore
    private List<OrderItem> orderItemList;

}
