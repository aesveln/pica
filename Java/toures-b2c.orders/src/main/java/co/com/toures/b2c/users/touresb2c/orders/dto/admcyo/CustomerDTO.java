
package co.com.toures.b2c.users.touresb2c.orders.dto.admcyo;

import java.math.BigDecimal;



public class CustomerDTO {

    private BigDecimal idCustomer;
    private String documentType;
    private String documentNumber;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String statusCust;
    private String category;

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
}
