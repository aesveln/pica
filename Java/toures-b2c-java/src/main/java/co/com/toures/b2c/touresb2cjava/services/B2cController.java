package co.com.toures.b2c.touresb2cjava.services;


import co.com.toures.b2c.touresb2cjava.dao.admpro.CityRepository;
import co.com.toures.b2c.touresb2cjava.dao.admpro.ProductRepository;
import co.com.toures.b2c.touresb2cjava.entity.admpro.City;
import co.com.toures.b2c.touresb2cjava.entity.admpro.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.MissingResourceException;

@RestController
public class B2cController {

    @Autowired
    private  CityRepository cityRepository;
    
    @Autowired
    private ProductRepository productRepository;



//    @GetMapping("/ciudades/{id}")
//    public City findById(@PathVariable(value = "id") int idCity) {
//
//        return cityRepository.findById(idCity);
//    }
    
    @GetMapping("/products/{id}")
    public Product findById(@PathVariable(value = "id") int idProduct)
    {
    	return productRepository.findById(idProduct);
    }



}
