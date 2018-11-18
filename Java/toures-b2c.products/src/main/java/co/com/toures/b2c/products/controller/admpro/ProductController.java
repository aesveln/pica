package co.com.toures.b2c.products.controller.admpro;

import co.com.toures.b2c.products.dto.admpro.CampaignDTO;
import co.com.toures.b2c.products.dto.admpro.ProductDTO;
import co.com.toures.b2c.products.entity.admpro.Campaign;
import co.com.toures.b2c.products.model.admpro.ProductRequest;
import co.com.toures.b2c.products.model.admpro.ProductResponse;
import co.com.toures.b2c.products.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@Api(description = "Set of endpoints for Retrieving Products.")
public class ProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping(method = RequestMethod.POST, value = "/api/products/getAll")
    @ApiOperation("Return all products")
    public ResponseEntity<ProductResponse> findAllProducts(@RequestBody ProductRequest productRequest) {
        try {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setProductos(productService.findAllProducts(productRequest));
            return ResponseEntity.ok(productResponse);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body(null);
        }

    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/products/findAllSpectacleProducts")
    @ApiOperation("Return all spectacle products")
    public ResponseEntity<ProductResponse> findAllSpectacleProducts(@RequestBody ProductRequest productRequest) {
        try {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setProductos(productService.findAllSpectacleProducts(productRequest));
            return ResponseEntity.ok(productResponse);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body(null);
        }

    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/products/findAllTransportProducts")
    @ApiOperation("Return all transport products")
    public ResponseEntity<ProductResponse> findAllTransportProducts(@RequestBody ProductRequest productRequest) {
        try {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setProductos(productService.findAllTransportProducts(productRequest));
            return ResponseEntity.ok(productResponse);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body(null);
        }

    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/products/findAllLodgingProducts")
    @ApiOperation("Return all lodging products")
    public ResponseEntity<ProductResponse> findAllLodgingProducts(@RequestBody ProductRequest productRequest) {
        try {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setProductos(productService.findAllLodgingProducts(productRequest));

            return ResponseEntity.ok(productResponse);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body(null);
        }

    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/products/findAllSpectacleByDate")
    @ApiOperation("Return all spectacle products by date")
    public ResponseEntity<ProductResponse> findAllSpectacleByDate(@RequestBody ProductRequest productRequest) {
        try {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setProductos(productService.findAllSpectacleByDate(productRequest));

            return ResponseEntity.ok(productResponse);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body(null);
        }

    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/products/findAllTransporByRangeDate")
    @ApiOperation("Return all transport products by range date")
    public ResponseEntity<ProductResponse> findAllTransporByRangeDate(@RequestBody ProductRequest productRequest) {
        try {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setProductos(productService.findAllTransporByRangeDate(productRequest));

            return ResponseEntity.ok(productResponse);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body(null);
        }

    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/products/findAllLodgingByRangeDate")
    @ApiOperation("Return all lodging products by range date")
    public ResponseEntity<ProductResponse> findAllLodgingByRangeDate(@RequestBody ProductRequest productRequest) {
        try {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setProductos(productService.findAllLodgingByRangeDate(productRequest));

            return ResponseEntity.ok(productResponse);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body(null);
        }

    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/products/productDetails/{codeProduct}")
    @ApiOperation("Return detailed product")
    public ProductDTO findProductDetail(@PathVariable String codeProduct) {
        try {

            return productService.findProductDetail(codeProduct);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/products/campaigns")
    @ApiOperation("Return campaigns product")
    public List<CampaignDTO> findCampaigns() {
        try {

            return productService.findCampaigns();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

}
