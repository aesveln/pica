package co.com.toures.b2c.touresb2cjava.entity.oracle;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Sales_Order")
@Getter
@Setter
public class SalesOrder {


    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "ORDER_DATE")
    private Date orderDate;
    private String price;
    private String status;
    private String comments;
    @Column(name = "CUST_DOCUMENT_NUMBER")
    private String custDocumentNumber;
    @Column(name = "CUST_DOCUMENT_TYPE")
    private String custDocumentType;

    public SalesOrder(Date orderDate, String price, String status, String comments, String custDocumentNumber, String custDocumentType) {
        this.orderDate = orderDate;
        this.price = price;
        this.status = status;
        this.comments = comments;
        this.custDocumentNumber = custDocumentNumber;
        this.custDocumentType = custDocumentType;
    }
}