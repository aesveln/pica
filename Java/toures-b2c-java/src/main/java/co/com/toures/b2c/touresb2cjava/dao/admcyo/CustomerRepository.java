package co.com.toures.b2c.touresb2cjava.dao.admcyo;

import co.com.toures.b2c.touresb2cjava.entity.admcyo.Customer;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;

public interface CustomerRepository extends CrudRepository<Customer, BigDecimal> {

}
