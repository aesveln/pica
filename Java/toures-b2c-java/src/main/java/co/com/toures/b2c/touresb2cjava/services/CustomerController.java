package co.com.toures.b2c.touresb2cjava.services;


import co.com.toures.b2c.touresb2cjava.dao.admcyo.CustomerRepository;
import co.com.toures.b2c.touresb2cjava.dao.admpro.CityRepository;
import co.com.toures.b2c.touresb2cjava.entity.admcyo.Customer;
import co.com.toures.b2c.touresb2cjava.entity.admpro.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.math.BigDecimal;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/user/{id}")
    public Customer findById(@PathVariable(value = "id") BigDecimal idCity) {

        return customerRepository.findById(idCity).orElseThrow(() -> new ResourceAccessException("Error"));
    }


}
