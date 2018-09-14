package co.com.toures.b2c.users.touresb2c.orders.dao.admcyo;

import org.springframework.data.repository.CrudRepository;

import co.com.toures.b2c.users.touresb2c.orders.entity.admcyo.Customer;

import java.math.BigDecimal;

public interface CustomerRepository extends CrudRepository<Customer, BigDecimal> {




}
