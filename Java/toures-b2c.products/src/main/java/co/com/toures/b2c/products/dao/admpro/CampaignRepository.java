package co.com.toures.b2c.products.dao.admpro;

import co.com.toures.b2c.products.entity.admpro.Campaign;
import co.com.toures.b2c.products.entity.admpro.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;


public interface CampaignRepository extends CrudRepository<Campaign, Long> {

    Iterable<Campaign> findAllByFromDateBeforeAndToDateAfter(Date date_from,Date date_to);
}
