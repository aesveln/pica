package co.com.toures.b2c.orders.dao.admcyo;

import org.springframework.data.repository.CrudRepository;

import co.com.toures.b2c.orders.entity.admcyo.OrderItem;

public interface OrderItemRepository extends CrudRepository<OrderItem, Integer>{

	OrderItem findById(int id);
}
