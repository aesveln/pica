package co.com.toures.b2c.touresb2cjava.dao.sqlserver;

import co.com.toures.b2c.touresb2cjava.entity.sqlserver.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long> {
}
