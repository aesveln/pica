package co.com.toures.b2c.users.model.admcyo;

import java.math.BigDecimal;

public class CustomerLoginRequest {

    private String correo;
    private String password;

    public CustomerLoginRequest() {
    }



    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
