package co.com.toures.b2c.orders.entity.admcyo;

import java.math.BigDecimal;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "ADMCYO", name = "ORDER_ITEM")
@Getter
@Setter
public class OrderItem {

	@Id
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;
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
    @JsonIgnore
    private SalesOrder orderId;
}
