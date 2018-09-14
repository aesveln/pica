package co.com.toures.b2c.products.dao.admpro;


import co.com.toures.b2c.products.entity.admpro.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Integer> {

    City findById(int idCity);
}