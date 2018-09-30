package co.com.toures.b2c.orders.entity.admcyo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "ADMCYO", name = "CUSTOMER")
@Getter
@Setter
public class Customer {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
    @JsonIgnore
    private List<SalesOrder> salesOrderList;
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
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getCreditcardType() {
		return creditcardType;
	}
	public void setCreditcardType(String creditcardType) {
		this.creditcardType = creditcardType;
	}
	public String getCreditcardNumber() {
		return creditcardNumber;
	}
	public void setCreditcardNumber(String creditcardNumber) {
		this.creditcardNumber = creditcardNumber;
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
	public List<SalesOrder> getSalesOrderList() {
		return salesOrderList;
	}
	public void setSalesOrderList(List<SalesOrder> salesOrderList) {
		this.salesOrderList = salesOrderList;
	}
    
    
}
