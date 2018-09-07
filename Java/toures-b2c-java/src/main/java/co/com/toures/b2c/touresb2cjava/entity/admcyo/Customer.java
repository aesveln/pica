
package co.com.toures.b2c.touresb2cjava.entity.admcyo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(schema = "ADMCYO",name = "CUSTOMER")
@Getter
@Setter
public class Customer  {

    @Id
    @Basic(optional = false)
    @Column(name = "ID_CUSTOMER")
    private BigDecimal idCustomer;
    @Column(name = "DOCUMENT_TYPE")
    private String documentType;
    @Column(name = "DOCUMENT_NUMBER")
    private String documentNumber;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASS")
    private String pass;
    @Column(name = "CREDITCARD_TYPE")
    private String creditcardType;
    @Column(name = "CREDITCARD_NUMBER")
    private String creditcardNumber;
    @Column(name = "STATUS_CUST")
    private String statusCust;
    @Column(name = "CATEGORY")
    private String category;
    @ManyToMany(mappedBy = "customerList")
    @JsonIgnore
    private List<Address> addressList;
    @JsonIgnore
    @OneToMany( mappedBy = "customerId")
    private List<SalesOrder> salesOrderList;
}
