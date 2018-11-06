
package co.com.toures.b2c.users.entity.admcyo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(schema = "ADMCYO", name = "CUSTOMER")

public class Customer {

    @Id
    @Column(name = "ID_CUSTOMER")
    @SequenceGenerator(name="customers_seq", sequenceName="customers_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="customers_seq")
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
    @Column(name = "STATUS_CUST")
    private String statusCust;
    @Column(name = "CATEGORY")
    private String category;
    @Column(name = "PASS")
    private String pass;
    @Column(name = "CREDITCARD_TYPE")
    private String creditcard_type;
    @Column(name = "CREDITCARD_NUMBER")
    private String creditcard_number;

    public Customer() {
    }

    public Customer(String documentType, String documentNumber, String firstName, String lastName, String phoneNumber, String email, String pass) {
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.statusCust = "1";
        this.pass = pass;
    }

    public BigDecimal getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(BigDecimal idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatusCust() {
        return statusCust;
    }

    public void setStatusCust(String statusCust) {
        this.statusCust = statusCust;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCreditcard_type() {
        return creditcard_type;
    }

    public void setCreditcard_type(String creditcard_type) {
        this.creditcard_type = creditcard_type;
    }

    public String getCreditcard_number() {
        return creditcard_number;
    }

    public void setCreditcard_number(String creditcard_number) {
        this.creditcard_number = creditcard_number;
    }
}
