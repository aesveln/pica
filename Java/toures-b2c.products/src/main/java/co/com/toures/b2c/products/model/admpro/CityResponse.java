package co.com.toures.b2c.products.model.admpro;

import co.com.toures.b2c.products.dto.admpro.CityDTO;

import java.util.List;

public class CityResponse {

    private List<CityDTO> ciudades;


    public List<CityDTO> getProductos() {
        return ciudades;
    }

    public void setProductos(List<CityDTO> ciudades) {
        this.ciudades = ciudades;
    }
}
