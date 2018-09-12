package co.com.toures.b2c.users.touresb2c.users.model.admcyo;

import java.math.BigDecimal;

public class CustomerRequest {


    private BigDecimal id;
    private String userName;


    public CustomerRequest() {
    }

    public CustomerRequest(BigDecimal id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
