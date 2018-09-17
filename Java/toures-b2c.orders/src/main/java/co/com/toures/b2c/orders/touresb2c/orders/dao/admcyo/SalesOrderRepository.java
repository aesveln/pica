package co.com.toures.b2c.orders.touresb2c.orders.dao.admcyo;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import co.com.toures.b2c.orders.touresb2c.orders.entity.admcyo.SalesOrder;

public interface SalesOrderRepository extends CrudRepository <SalesOrder, BigDecimal>{

}
