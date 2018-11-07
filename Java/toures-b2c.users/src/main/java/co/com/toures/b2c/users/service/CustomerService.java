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
import javax.xml.datatype.DatatypeConfigurationException;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    
//    @Autowired
//    CustomerClient customerclient = new CustomerClient();
//    
//    @Autowired
//    BpelClient bpel = new BpelClient();

    ModelMapper modelMapper = new ModelMapper();


    public String loginUser(CustomerLoginRequest customerLoginRequest) throws DatatypeConfigurationException {

        Customer cust = customerRepository.findByEmail(customerLoginRequest.getCorreo());
        CustomerDTO customerDTO = modelMapper.map(cust, CustomerDTO.class);
        boolean status = false;
        boolean tarjetaValida = false;
        double descuento = 0;
        String valida = "";
        if (customerDTO.getPass().toLowerCase().equals(customerLoginRequest.getPassword().toLowerCase())) {
            status = true;
            if(customerDTO.getCategory().equals("Dorado"))
            {
            	descuento = 0.25;
            }
            if(customerDTO.getCategory().equals("Plateado"))
            {
            	descuento = 0.15;
            }
            if(customerDTO.getCategory().equals("Platino"))
            {
            	descuento = 0.35;
            }
            
          
            tarjetaValida = validatc(customerDTO.getCreditcard_number());
           
            if(tarjetaValida) {
            	valida="Tarjeta Valida";
            }else {
            	valida="Tarjeta NO Valida";
            }
            
        }

        return co.com.toures.b2c.users.conf.JwtApplication.JwtToken(status, "asd", customerDTO, descuento, valida);
    }

    public CustomerResponse createCustomer(CustomerRequest customerRequest) {

        Customer cust = new Customer(customerRequest.getDocumentType(), customerRequest.getDocumentNumber(), customerRequest.getFirstName(), customerRequest.getLastName(), customerRequest.getPhoneNumber(), customerRequest.getEmail(), customerRequest.getPass());


        Object a = customerRepository.save(cust);

        System.out.println(a);
        CustomerResponse cr = new CustomerResponse();
        cr.setCreado(true);
        return cr;
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

        CustomerResponse cr = new CustomerResponse();
        cr.setCreado(true);
        return cr;
    }
    
    public double getDescuento (String categoria) throws DatatypeConfigurationException
	{
		//return customerclient.getRespuestaServicio(categoria);
    	return 0;
	}
    
    public boolean validatc (String tc)
    {
    	boolean valida = false;
    	
    	if(tc.length()>=12 && tc.length()<=16)
    	{
    		if(tc.startsWith("4") || tc.startsWith("5") || tc.startsWith("6"))
    		{
    			valida=true;
    		}else {
    			valida=false;
    		}
    	}
    	return valida;
    }
}
