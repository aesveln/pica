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

    @Query(value = "select * from ADMPRO.PRODUCT P inner join ADMPRO.SPECTACLE S on P.spectacle_type = S.Id where S.spectacle_date > GETDATE()",
            nativeQuery = true)
    Page<Product> findAllSpectacleProducts(Pageable pageable);

    @Query(value = "select * from ADMPRO.PRODUCT P inner join ADMPRO.TRANSPORT T on P.transport_type = T.Id where  T.depart_date > GETDATE()",
            nativeQuery = true)
    Page<Product> findAllTransportProducts(Pageable pageable);

    @Query(value = "select * from ADMPRO.PRODUCT P inner join ADMPRO.LODGING L on P.lodging_type = L.Id where  L.departure_date > GETDATE()",
            nativeQuery = true)
    Page<Product> findAllLodgingProducts(Pageable pageable);

}
