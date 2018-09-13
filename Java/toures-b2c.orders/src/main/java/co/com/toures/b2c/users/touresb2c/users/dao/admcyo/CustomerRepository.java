package co.com.toures.b2c.users.touresb2c.users.dao.admcyo;

import co.com.toures.b2c.users.touresb2c.users.entity.admcyo.Customer;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;

public interface CustomerRepository extends CrudRepository<Customer, BigDecimal> {




}
