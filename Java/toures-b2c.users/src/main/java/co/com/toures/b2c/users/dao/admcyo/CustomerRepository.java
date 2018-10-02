package co.com.toures.b2c.users.dao.admcyo;

import co.com.toures.b2c.users.entity.admcyo.Customer;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;

public interface CustomerRepository extends CrudRepository<Customer, BigDecimal> {

    Customer findByEmail(String email);



}
