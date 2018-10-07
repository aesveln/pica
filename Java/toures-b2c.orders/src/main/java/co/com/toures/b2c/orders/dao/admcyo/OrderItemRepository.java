package co.com.toures.b2c.orders.dao.admcyo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import co.com.toures.b2c.orders.entity.admcyo.OrderItem;

public interface OrderItemRepository extends CrudRepository<OrderItem, Integer>{

	OrderItem findById(int id);
	
	@Transactional
	@Modifying
	@Query(value="insert into order_item (product_cod, product_name, price, quantity) values (?, ?, ?, ?)", nativeQuery = true)
	void crearOrden(int productcod, String name, long price, int quantity);
	
	@Query(value="select * from  order_item where order_id = ?", nativeQuery = true)
	List<OrderItem> detalleOrdenes (int idsale, Pageable pageable);
}
