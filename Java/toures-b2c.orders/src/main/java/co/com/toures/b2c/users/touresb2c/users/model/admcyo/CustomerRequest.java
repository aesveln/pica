package co.com.toures.b2c.users.touresb2c.users.model.admcyo;

import java.math.BigDecimal;

public class CustomerRequest {


    private BigDecimal id;
    private String correo;

    public CustomerRequest() {
    }

    public CustomerRequest(BigDecimal id, String correo) {
        this.id = id;
        this.correo = correo;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
