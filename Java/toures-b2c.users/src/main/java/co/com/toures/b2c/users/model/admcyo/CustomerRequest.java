package co.com.toures.b2c.users.model.admcyo;

import java.math.BigDecimal;

public class CustomerRequest {

    private BigDecimal id;
    private String documentType;
    private String documentNumber;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String pass;
    private String creditcard_type;
    private String creditcard_number;


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

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }
}
