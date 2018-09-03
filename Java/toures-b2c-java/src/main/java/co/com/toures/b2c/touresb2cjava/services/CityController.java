package co.com.toures.b2c.touresb2cjava.services;


import co.com.toures.b2c.touresb2cjava.dao.oracle.SalesOrderRepository;
import co.com.toures.b2c.touresb2cjava.dao.sqlserver.CityRepository;
import co.com.toures.b2c.touresb2cjava.entity.oracle.SalesOrder;
import co.com.toures.b2c.touresb2cjava.entity.sqlserver.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {


    private final CityRepository cityRepository;
    private final SalesOrderRepository salesOrderRepository;


    @Autowired
    CityController(CityRepository cityRepository, SalesOrderRepository salesOrderRepository) {
        this.cityRepository = cityRepository;
        this.salesOrderRepository = salesOrderRepository;
    }

    @RequestMapping("/ciudades")
    public Iterable<City> ciudades() {
        Iterable<City> ciudades = cityRepository.findAll();
        return ciudades;
    }


    @RequestMapping("/salesorders")
    public Iterable<SalesOrder> salesorders() {
        Iterable<SalesOrder> sales = salesOrderRepository.findAll();
        return sales;
    }

}
