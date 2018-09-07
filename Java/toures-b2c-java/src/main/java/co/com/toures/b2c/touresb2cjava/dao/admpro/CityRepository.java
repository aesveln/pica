package co.com.toures.b2c.touresb2cjava.dao.admpro;

import co.com.toures.b2c.touresb2cjava.entity.admpro.City;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CityRepository extends CrudRepository<City, Integer> {

    City findById(int idCity);
}