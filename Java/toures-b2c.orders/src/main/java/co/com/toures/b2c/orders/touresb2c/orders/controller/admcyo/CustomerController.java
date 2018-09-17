package co.com.toures.b2c.users.touresb2c.orders.controller.admcyo;


import co.com.toures.b2c.users.touresb2c.orders.dto.admcyo.CustomerDTO;
import co.com.toures.b2c.users.touresb2c.orders.model.admcyo.CustomerRequest;
import co.com.toures.b2c.users.touresb2c.orders.model.admcyo.CustomerResponse;
import co.com.toures.b2c.users.touresb2c.orders.service.CustomerService;

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

    @RequestMapping(method = RequestMethod.POST, value =  "/api/users/info")
    public CustomerResponse ValidateUser(@RequestBody CustomerRequest userRequest) {

        CustomerDTO customer = customerService.getUserInfoById(userRequest);

        CustomerResponse custResp = new CustomerResponse();

        custResp = modelMapper.map(customer,CustomerResponse.class);

        return custResp;

    }


}
