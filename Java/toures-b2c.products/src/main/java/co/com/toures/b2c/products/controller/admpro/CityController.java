package co.com.toures.b2c.products.controller.admpro;

import co.com.toures.b2c.products.model.admpro.CityRequest;
import co.com.toures.b2c.products.model.admpro.CityResponse;
import co.com.toures.b2c.products.model.admpro.ProductRequest;
import co.com.toures.b2c.products.model.admpro.ProductResponse;
import co.com.toures.b2c.products.service.CityService;
import co.com.toures.b2c.products.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "Set of endpoints for Retrieving cities.")
public class CityController {

    @Autowired
    private CityService cityService;


    @RequestMapping(method = RequestMethod.GET, value = "/api/cities/getAll")
    @ApiOperation("Return all cities")
    public ResponseEntity<CityResponse> findAllCities() {
        try {
            CityResponse cityResponse = new CityResponse();

            cityResponse.setProductos(cityService.findAllCities());

            return ResponseEntity.ok(cityResponse);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body(null);

        }

    }

}
