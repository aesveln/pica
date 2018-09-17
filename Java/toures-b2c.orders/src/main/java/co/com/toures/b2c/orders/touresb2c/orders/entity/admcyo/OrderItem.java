package co.com.toures.b2c.orders.touresb2c.orders.entity.admcyo;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(schema = "ADMCYO", name = "ORDER_ITEM")
@Getter
@Setter

public class OrderItem {
	
		@Id
	    @Basic(optional = false)
	    @Column(name = "ID")
	    private BigDecimal id;
	    @Column(name = "PRODUCT_COD")
	    private String productCod;
	    @Column(name = "PRODUCT_NAME")
	    private String productName;
	    @Column(name = "PRICE")
	    private Long price;
	    @Column(name = "QUANTITY")
	    private Integer quantity;
	    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ID_SALES")
	    @ManyToOne
	    private SalesOrder orderId;

}
