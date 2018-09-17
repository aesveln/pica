package co.com.toures.b2c.products.dao.admpro;

import co.com.toures.b2c.products.entity.admpro.City;
import co.com.toures.b2c.products.entity.admpro.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CityRepository extends CrudRepository<City, Integer> {


    @Query(value = "select * from ADMPRO.CITY C order by C.name asc",
            nativeQuery = true)
    List<City> findAll();


}
