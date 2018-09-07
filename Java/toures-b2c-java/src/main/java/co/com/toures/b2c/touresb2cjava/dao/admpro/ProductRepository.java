package co.com.toures.b2c.touresb2cjava.dao.admpro;

import org.springframework.data.repository.CrudRepository;

import co.com.toures.b2c.touresb2cjava.entity.admpro.Product;


public interface ProductRepository extends CrudRepository<Product, Long>{

	Product findById(int idProduct);
}
