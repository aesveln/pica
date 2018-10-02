package co.com.toures.b2c.orders.dto.admcyo;

import java.math.BigDecimal;
import java.util.List;



import co.com.toures.b2c.orders.entity.admcyo.SalesOrder;

public class CustomerDTO {

	private BigDecimal idCustomer;
    private String documentType;
    private String documentNumber;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String pass;
    private String creditcardType;
    private String creditcardNumber;
    private String statusCust;
    private String category;
    private List<SalesOrder> salesOrderList;
    
    
	public CustomerDTO() {
		
	}
	public CustomerDTO(BigDecimal idCustomer, String documentType, String documentNumber, String firstName,
			String lastName, String phoneNumber, String email, String pass, String creditcardType,
			String creditcardNumber, String statusCust, String category, List<SalesOrder> salesOrderList) {
	
		this.idCustomer = idCustomer;
		this.documentType = documentType;
		this.documentNumber = documentNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.pass = pass;
		this.creditcardType = creditcardType;
		this.creditcardNumber = creditcardNumber;
		this.statusCust = statusCust;
		this.category = category;
		this.salesOrderList = salesOrderList;
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
