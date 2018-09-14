package co.com.toures.b2c.products.model.admpro;

import java.math.BigDecimal;

public class ProductRequest {

    private String  entrada;

    public ProductRequest() {
    }

    public ProductRequest(String entrada) {
        this.entrada = entrada;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }
}
