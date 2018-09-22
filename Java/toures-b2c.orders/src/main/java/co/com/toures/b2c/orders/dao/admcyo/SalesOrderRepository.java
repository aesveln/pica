package co.com.toures.b2c.orders.dao.admcyo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import co.com.toures.b2c.orders.entity.admcyo.SalesOrder;

public interface SalesOrderRepository extends CrudRepository<SalesOrder, Integer> {

	List<SalesOrder> findBystatusOrder(String status);
	
	@Query(value="select * from sales_order where status_order not in ('CERR','RECH','CONC') ",
			 nativeQuery = true)
	
	List<SalesOrder> findOpenSales();
	
	@Transactional
	@Modifying
	@Query(value="update sales_order set status_order='CONC' where id_sales = ?", nativeQuery = true)
	int cancelSaleOrder (int idSale);
	
	@Query(value="select * from sales_order where customer_id = ?", nativeQuery = true)
	List<SalesOrder> ordenesCliente (int idCliente);
	
	
	
}
