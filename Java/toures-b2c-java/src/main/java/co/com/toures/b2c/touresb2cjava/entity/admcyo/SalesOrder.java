
package co.com.toures.b2c.touresb2cjava.entity.admcyo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Entity
@Table(schema = "ADMCYO",name = "SALES_ORDER")
@Getter
@Setter
public class SalesOrder implements Serializable {

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
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID_CUSTOMER")
    @ManyToOne(optional = false)
    private Customer customerId;
    @OneToMany(mappedBy = "orderId")
    private List<OrderItem> orderItemList;

}
