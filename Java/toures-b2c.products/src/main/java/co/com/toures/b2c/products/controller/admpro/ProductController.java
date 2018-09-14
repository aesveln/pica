package co.com.toures.b2c.products.controller.admpro;

import co.com.toures.b2c.products.model.admpro.ProductRequest;
import co.com.toures.b2c.products.model.admpro.ProductResponse;
import co.com.toures.b2c.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping(method = RequestMethod.POST, value =  "/api/products/getAll")
    public ProductResponse findAllProducts(@RequestBody ProductRequest productRequest) {

        ProductResponse productResponse = new ProductResponse();

        productResponse.setProductos(productService.findAllProducts(productRequest));


        return productResponse;

    }


}
