package co.com.toures.b2c.users.service;

import co.com.toures.b2c.users.dao.admcyo.CustomerRepository;
import co.com.toures.b2c.users.dto.admcyo.CustomerDTO;
import co.com.toures.b2c.users.entity.admcyo.Customer;
import co.com.toures.b2c.users.model.admcyo.CustomerLoginRequest;
import co.com.toures.b2c.users.model.admcyo.CustomerRequest;
import co.com.toures.b2c.users.model.admcyo.CustomerResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    
    @Autowired
    CustomerClient customerclient = new CustomerClient();

    ModelMapper modelMapper = new ModelMapper();


    public String loginUser(CustomerLoginRequest customerLoginRequest) {

        Customer cust = customerRepository.findByEmail(customerLoginRequest.getCorreo());
        CustomerDTO customerDTO = modelMapper.map(cust, CustomerDTO.class);
        boolean status = false;
        double descuento;
        if (customerDTO.getPass().toLowerCase().equals(customerLoginRequest.getPassword().toLowerCase())) {
            status = true;
            descuento = getDescuento(customerDTO.getCategory());
            
        }

        return co.com.toures.b2c.users.conf.JwtApplication.JwtToken(status, "asd", customerDTO);
    }

    public CustomerResponse createCustomer(CustomerRequest customerRequest) {

        Customer cust = new Customer(customerRequest.getDocumentType(), customerRequest.getDocumentNumber(), customerRequest.getFirstName(), customerRequest.getLastName(), customerRequest.getPhoneNumber(), customerRequest.getEmail(), customerRequest.getPass());


        Object a = customerRepository.save(cust);

        System.out.println(a);

        return new CustomerResponse();
    }

    public Object updateCustomer(CustomerRequest customerRequest) {

        Customer cust = customerRepository.findById(customerRequest.getId()).get();

        cust.setDocumentNumber(customerRequest.getDocumentNumber());
        cust.setDocumentType(customerRequest.getDocumentType());
        cust.setEmail(customerRequest.getEmail());
        cust.setFirstName(customerRequest.getFirstName());
        cust.setLastName(customerRequest.getLastName());
        cust.setPass(customerRequest.getPass());
        cust.setPhoneNumber(customerRequest.getPhoneNumber());
        cust.setCreditcard_type(customerRequest.getCreditcard_type());
        cust.setCreditcard_number(customerRequest.getCreditcard_number());

        customerRepository.save(cust);

        return new CustomerResponse();
    }
    
    public double getDescuento (String categoria)
	{
		return customerclient.getRespuestaServicio(categoria);
	}
}
