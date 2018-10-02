package co.com.toures.b2c.users.controller.admcyo;


import co.com.toures.b2c.users.model.admcyo.CustomerLoginRequest;
import co.com.toures.b2c.users.model.admcyo.CustomerRequest;
import co.com.toures.b2c.users.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;


@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    ModelMapper modelMapper = new ModelMapper();
//    @GetMapping("/users/{id}")
//    public CustomerDTO findById(@PathVariable(value = "id") BigDecimal idCity) {
//
//        return customerRepository.findById(idCity).orElse(null);
//    }


    @RequestMapping(method = RequestMethod.POST, value = "/api/users/login")
    public String UserLogin(@RequestBody CustomerLoginRequest customerLoginRequest) {

        try {
            return "{ \"token\" : \"" + customerService.loginUser(customerLoginRequest) + "\"}";
        } catch (Exception e) {
            return "";
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/users/createCustomer")
    public Object CreateCustomer(@RequestBody CustomerRequest customerRequest) {

        try {
            return customerService.createCustomer(customerRequest);
        } catch (Exception e) {
            return "";
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/users/updateCustomer")
    public Object UpdateCustomer(@RequestBody CustomerRequest customerRequest) {

        try {
            return customerService.updateCustomer(customerRequest);
        } catch (Exception e) {
            return "";
        }
    }
}
