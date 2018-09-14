package co.com.toures.b2c.products.model.admpro;

import co.com.toures.b2c.products.dto.admpro.ProductDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public class ProductResponse {

    private Page<ProductDTO> productos;


    public Page<ProductDTO> getProductos() {
        return productos;
    }

    public void setProductos(Page<ProductDTO> productos) {
        this.productos = productos;
    }
}
