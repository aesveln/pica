package co.com.toures.b2c.products.dao.admpro;

import co.com.toures.b2c.products.entity.admpro.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ProductRepository extends CrudRepository<Product, Long> {

    Product findById(int idProduct);

    Page<Product> findAll(Pageable pageable);

    @Query(value="select * from ADMPRO.PRODUCT P inner join ADMPRO.SPECTACLE S on P.spectacle_type = S.Id where S.spectacle_date > GETDATE()",
    nativeQuery = true)
    Page<Product> findAllSpectacleProducts(Pageable pageable);
}
