package co.com.toures.b2c.products.service;


import co.com.toures.b2c.products.dao.admpro.ProductRepository;
import co.com.toures.b2c.products.dto.admpro.ProductDTO;
import co.com.toures.b2c.products.entity.admpro.Product;
import co.com.toures.b2c.products.model.admpro.ProductRequest;
import org.modelmapper.Converters;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ProductService {


    @Autowired
    ProductRepository productRepository;

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


}
