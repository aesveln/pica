package co.com.toures.b2c.orders.dao.admcyo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import co.com.toures.b2c.orders.entity.admcyo.OrderItem;
import co.com.toures.b2c.orders.entity.admcyo.SalesOrder;

public interface SalesOrderRepository extends CrudRepository<SalesOrder, Integer> {

	
	List<SalesOrder> findBystatusOrder(String status, Pageable pageable);
	
	@Query(value="select * from sales_order where status_order not in ('CERR','RECH','CONC') and customer_id = ? ",
			 nativeQuery = true)
	
	List<SalesOrder> findOpenSales(int idCliente, Pageable pageable);
	
	@Transactional
	@Modifying
	@Query(value="update sales_order set status_order='CONC' where id_sales = ? ", nativeQuery = true)
	int cancelSaleOrder (int idSale);
	
	@Query(value="select * from sales_order where customer_id = ?", nativeQuery = true)
	List<SalesOrder> ordenesCliente (int idCliente, Pageable pageable);
	
	@Transactional
	@Modifying
	@Query(value="insert into sales_order (id_sales, ORDER_DATE, price, STATUS_ORDER, comments, customer_id) values (?, SYSDATE, ? , 'RESE', ? , ?)", nativeQuery = true)
	void createSaleOrder (int orderid, long price, String comments, int customerid);
	
	@Query(value="select * from sales_order where id_sales = ? ", nativeQuery = true)
	SalesOrder findSale(int idsale);
	
	@Query(value="select max_pk   from ( select a.*, max(id_sales) over () as max_pk  from sales_order ) where id_sales = max_pk", nativeQuery = true)
	int findlastSale();
	
	
	
	
}
