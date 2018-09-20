package co.com.toures.b2c.products.dao.admpro;

import co.com.toures.b2c.products.entity.admpro.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
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


    @Query(value = "SELECT * FROM ADMPRO.PRODUCT P INNER JOIN ADMPRO.SPECTACLE S ON P.spectacle_type = S.Id WHERE S.spectacle_date = :spectacleDate",
            nativeQuery = true)
    Page<Product> findAllSpectacleByDate(Pageable pageable, @Param("spectacleDate") Date spectacleDate);

    @Query(value = "SELECT * FROM ADMPRO.PRODUCT P INNER JOIN ADMPRO.TRANSPORT T ON P.transport_type = T.Id WHERE T.depart_date = :depart_date AND T.return_date = :return_date",
            nativeQuery = true)
    Page<Product> findAllTransporByRangeDate(Pageable pageable, @Param("depart_date") Date depart_date,@Param("return_date") Date return_date);

    @Query(value = "SELECT * FROM ADMPRO.PRODUCT P INNER JOIN ADMPRO.LODGING L ON P.lodging_type = L.Id WHERE L.arrival_date = :arrivalDate AND L.departure_date = :departureDate",
            nativeQuery = true)
    Page<Product> findAllLodgingByRangeDate(Pageable pageable, @Param("arrivalDate") Date arrivalDate,@Param("departureDate") Date departureDate);


}
