package co.com.toures.b2c.products.service;


import co.com.toures.b2c.products.dao.admpro.CityRepository;
import co.com.toures.b2c.products.dto.admpro.CityDTO;
import co.com.toures.b2c.products.entity.admpro.City;
import co.com.toures.b2c.products.utils.ObjectMapperUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {


    @Autowired
    CityRepository cityRepository;

    ModelMapper modelMapper = new ModelMapper();


    public List<CityDTO> findAllCities() {

        List<City> ciudades = cityRepository.findAll();

        List<CityDTO> ciudadesDTO = ObjectMapperUtils.mapAll(ciudades,CityDTO.class);


        return ciudadesDTO;

    }


}
