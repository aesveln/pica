package co.com.toures.b2c.touresb2cjava.dao.oracle;

import co.com.toures.b2c.touresb2cjava.entity.oracle.SalesOrder;
import org.springframework.data.repository.CrudRepository;

public interface SalesOrderRepository extends CrudRepository<SalesOrder, Integer> {
}
