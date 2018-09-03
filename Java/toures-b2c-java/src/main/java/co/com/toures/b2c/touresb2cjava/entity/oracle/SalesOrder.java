package co.com.toures.b2c.touresb2cjava.entity.oracle;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table (name = "Sales_Order")
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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public java.sql.Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(java.sql.Date orderDate) {
        this.orderDate = orderDate;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }


    public String getCustDocumentNumber() {
        return custDocumentNumber;
    }

    public void setCustDocumentNumber(String custDocumentNumber) {
        this.custDocumentNumber = custDocumentNumber;
    }


    public String getCustDocumentType() {
        return custDocumentType;
    }

    public void setCustDocumentType(String custDocumentType) {
        this.custDocumentType = custDocumentType;
    }

}