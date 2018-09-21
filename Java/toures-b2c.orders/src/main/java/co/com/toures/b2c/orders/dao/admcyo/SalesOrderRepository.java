package co.com.toures.b2c.orders.dao.admcyo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.com.toures.b2c.orders.entity.admcyo.SalesOrder;

public interface SalesOrderRepository extends CrudRepository<SalesOrder, BigDecimal> {

	List<SalesOrder> findBystatusOrder(String status);
	
	@Query(value="select * from sales_order where status_order not in ('CERR','RECH','CONC') ",
			 nativeQuery = true)
	
	List<SalesOrder> findOpenSales();
	
	@Query(value="update sales_order set status_order='CONC' where id_sales = :idSale", nativeQuery = true)
	void cancelSaleOrder (@Param("idSale") int idSale);
}
