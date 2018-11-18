package co.com.toures.b2c.products.service;


import co.com.toures.b2c.products.dao.admpro.CampaignRepository;
import co.com.toures.b2c.products.dao.admpro.ProductRepository;
import co.com.toures.b2c.products.dto.admpro.CampaignDTO;
import co.com.toures.b2c.products.dto.admpro.ProductDTO;
import co.com.toures.b2c.products.entity.admpro.Campaign;
import co.com.toures.b2c.products.entity.admpro.Product;
import co.com.toures.b2c.products.model.admpro.ProductRequest;
import co.com.toures.b2c.products.utils.ObjectMapperUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.Converters;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

@Service
public class ProductService {


    @Autowired
    ProductRepository productRepository;

    @Autowired
    CampaignRepository campaignRepository;

    ModelMapper modelMapper = new ModelMapper();


    public Page<ProductDTO> findAllProducts(ProductRequest productRequest) {

        Pageable pageable = PageRequest.of(0, 10);

        Page<Product> productos = productRepository.findAll(pageable);

        Page<ProductDTO> productosDTO = productos.map(new Function<Product, ProductDTO>() {
            @Override
            public ProductDTO apply(Product entity) {
                ProductDTO dto = new ProductDTO();
                dto = modelMapper.map(entity, ProductDTO.class);

                return dto;
            }
        });

        return productosDTO;

    }


    public Page<ProductDTO> findAllSpectacleProducts(ProductRequest productRequest) {

        Pageable pageable;


        if (productRequest.getSortBy().equals("") || productRequest.getSortBy().isEmpty()) {
            pageable = PageRequest.of(productRequest.getPageNumber(), productRequest.getPageSize());
        } else {
            String sortBy = ("S.").concat(productRequest.getSortBy());
            Sort sort = Sort.by(Sort.Direction.ASC, sortBy);
            pageable = PageRequest.of(productRequest.getPageNumber(), productRequest.getPageSize(), sort);
        }
        Page<Product> productos = productRepository.findAllSpectacleProducts(pageable);

        Page<ProductDTO> productosDTO = productos.map(new Function<Product, ProductDTO>() {
            @Override
            public ProductDTO apply(Product entity) {
                ProductDTO dto = new ProductDTO();
                dto = modelMapper.map(entity, ProductDTO.class);

                return dto;
            }
        });

        return productosDTO;

    }


    public Page<ProductDTO> findAllTransportProducts(ProductRequest productRequest) {

        Pageable pageable;
        if (productRequest.getSortBy().equals("") || productRequest.getSortBy().isEmpty()) {

            pageable = PageRequest.of(productRequest.getPageNumber(), productRequest.getPageSize());
        } else {
            String sortBy = ("T.").concat(productRequest.getSortBy());
            Sort sort = Sort.by(Sort.Direction.ASC, sortBy);
            pageable = PageRequest.of(productRequest.getPageNumber(), productRequest.getPageSize(), sort);
        }
        Page<Product> productos = productRepository.findAllTransportProducts(pageable);

        Page<ProductDTO> productosDTO = productos.map(new Function<Product, ProductDTO>() {
            @Override
            public ProductDTO apply(Product entity) {
                ProductDTO dto = new ProductDTO();
                dto = modelMapper.map(entity, ProductDTO.class);

                return dto;
            }
        });

        return productosDTO;

    }

    public Page<ProductDTO> findAllLodgingProducts(ProductRequest productRequest) {

        Pageable pageable;
        if (productRequest.getSortBy().equals("") || productRequest.getSortBy().isEmpty()) {

            pageable = PageRequest.of(productRequest.getPageNumber(), productRequest.getPageSize());
        } else {
            String sortBy = ("L.").concat(productRequest.getSortBy());
            Sort sort = Sort.by(Sort.Direction.ASC, sortBy);
            pageable = PageRequest.of(productRequest.getPageNumber(), productRequest.getPageSize(), sort);
        }
        Page<Product> productos = productRepository.findAllLodgingProducts(pageable);

        Page<ProductDTO> productosDTO = productos.map(new Function<Product, ProductDTO>() {
            @Override
            public ProductDTO apply(Product entity) {
                ProductDTO dto = new ProductDTO();
                dto = modelMapper.map(entity, ProductDTO.class);

                return dto;
            }
        });

        return productosDTO;

    }

    public Page<ProductDTO> findAllSpectacleByDate(ProductRequest productRequest) throws ParseException {


        Pageable pageable;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date spectacleDate = dateFormat.parse(productRequest.getSpectacleDate());

        if (productRequest.getSortBy().equals("") || productRequest.getSortBy().isEmpty()) {
            pageable = PageRequest.of(productRequest.getPageNumber(), productRequest.getPageSize());
        } else {
            String sortBy = ("S.").concat(productRequest.getSortBy());
            Sort sort = Sort.by(Sort.Direction.ASC, sortBy);
            pageable = PageRequest.of(productRequest.getPageNumber(), productRequest.getPageSize(), sort);
        }
        Page<Product> productos = productRepository.findAllSpectacleByDate(pageable, new java.sql.Date(spectacleDate.getTime()));

        Page<ProductDTO> productosDTO = productos.map(new Function<Product, ProductDTO>() {
            @Override
            public ProductDTO apply(Product entity) {
                ProductDTO dto = new ProductDTO();
                dto = modelMapper.map(entity, ProductDTO.class);

                return dto;
            }
        });

        return productosDTO;
    }


    public Page<ProductDTO> findAllTransporByRangeDate(ProductRequest productRequest) throws ParseException {


        Pageable pageable;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date depart_date = dateFormat.parse(productRequest.getDepartureDate());
        Date return_date = dateFormat.parse(productRequest.getReturn_date());

        if (productRequest.getSortBy().equals("") || productRequest.getSortBy().isEmpty()) {
            pageable = PageRequest.of(productRequest.getPageNumber(), productRequest.getPageSize());
        } else {
            String sortBy = ("S.").concat(productRequest.getSortBy());
            Sort sort = Sort.by(Sort.Direction.ASC, sortBy);
            pageable = PageRequest.of(productRequest.getPageNumber(), productRequest.getPageSize(), sort);
        }
        Page<Product> productos = productRepository.findAllTransporByRangeDate(pageable, new java.sql.Date(depart_date.getTime()), new java.sql.Date(return_date.getTime()));

        Page<ProductDTO> productosDTO = productos.map(new Function<Product, ProductDTO>() {
            @Override
            public ProductDTO apply(Product entity) {
                ProductDTO dto = new ProductDTO();
                dto = modelMapper.map(entity, ProductDTO.class);

                return dto;
            }
        });

        return productosDTO;
    }

    public Page<ProductDTO> findAllLodgingByRangeDate(ProductRequest productRequest) throws ParseException {


        Pageable pageable;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date arrivalDate = dateFormat.parse(productRequest.getArrivalDate());
        Date departureDate = dateFormat.parse(productRequest.getDepartureDate());

        if (productRequest.getSortBy().equals("") || productRequest.getSortBy().isEmpty()) {
            pageable = PageRequest.of(productRequest.getPageNumber(), productRequest.getPageSize());
        } else {
            String sortBy = ("L.").concat(productRequest.getSortBy());
            Sort sort = Sort.by(Sort.Direction.ASC, sortBy);
            pageable = PageRequest.of(productRequest.getPageNumber(), productRequest.getPageSize(), sort);
        }
        Page<Product> productos = productRepository.findAllLodgingByRangeDate(pageable, new java.sql.Date(arrivalDate.getTime()), new java.sql.Date(departureDate.getTime()));

        Page<ProductDTO> productosDTO = productos.map(new Function<Product, ProductDTO>() {
            @Override
            public ProductDTO apply(Product entity) {
                ProductDTO dto = new ProductDTO();
                dto = modelMapper.map(entity, ProductDTO.class);

                return dto;
            }
        });

        return productosDTO;
    }


    public ProductDTO findProductDetail(String codeProduct) {

        Product producto = productRepository.findByCod(codeProduct);

        ProductDTO productDTO = modelMapper.map(producto, ProductDTO.class);
        return productDTO;
    }

    public List<CampaignDTO> findCampaigns() {


        java.sql.Date ahora = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        List<Campaign> campaigns = (List<Campaign>) campaignRepository.findAllByFromDateBeforeAndToDateAfter(ahora, ahora);
        List<CampaignDTO> campanias = ObjectMapperUtils.mapAll(campaigns,CampaignDTO.class);

        return campanias;

    }
}
