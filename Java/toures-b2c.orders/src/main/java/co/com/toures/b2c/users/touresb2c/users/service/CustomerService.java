package co.com.toures.b2c.users.touresb2c.users.service;

import co.com.toures.b2c.users.touresb2c.users.dao.admcyo.CustomerRepository;
import co.com.toures.b2c.users.touresb2c.users.dto.admcyo.CustomerDTO;
import co.com.toures.b2c.users.touresb2c.users.entity.admcyo.Customer;
import co.com.toures.b2c.users.touresb2c.users.model.admcyo.CustomerRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    ModelMapper modelMapper = new ModelMapper();


    public CustomerDTO getUserInfoById(CustomerRequest userRequest) {

        Customer customerEntity = customerRepository.findById(userRequest.getId()).orElse(null);

        CustomerDTO cust = modelMapper.map(customerEntity,CustomerDTO.class);

        return cust;

    }

}
