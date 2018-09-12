package co.com.toures.b2c.users.touresb2c.users.controller.admcyo;


import co.com.toures.b2c.users.touresb2c.users.dao.admcyo.CustomerRepository;
import co.com.toures.b2c.users.touresb2c.users.entity.admcyo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import java.math.BigDecimal;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/users/{id}")
    public Customer findById(@PathVariable(value = "id") BigDecimal idCity) {

        return customerRepository.findById(idCity).orElse(null);
    }


}
