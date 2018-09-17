package co.com.toures.b2c.orders.touresb2c.orders.entity.admcyo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(schema = "ADMCYO", name = "SALES_ORDER")
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class SalesOrder {

	@Id
    @Basic(optional = false)
    @Column(name = "ID_SALES")
    private BigDecimal idSales;
    @Column(name = "ORDER_DATE")
    @Temporal(TemporalType.TIMESTAMP)
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
