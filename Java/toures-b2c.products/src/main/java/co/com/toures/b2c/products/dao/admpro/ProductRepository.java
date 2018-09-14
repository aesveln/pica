package co.com.toures.b2c.products.dao.admpro;

import co.com.toures.b2c.products.entity.admpro.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ProductRepository extends CrudRepository<Product, Long> {

	Product findById(int idProduct);
	Page<Product> findAll(Pageable pageable);
}
