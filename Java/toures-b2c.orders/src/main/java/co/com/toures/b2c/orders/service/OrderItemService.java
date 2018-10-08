package co.com.toures.b2c.orders.service;

import co.com.toures.b2c.orders.dao.admcyo.OrderItemRepository;
import co.com.toures.b2c.orders.dto.admcyo.OrderItemDTO;
import co.com.toures.b2c.orders.entity.admcyo.OrderItem;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    OrderItemRepository orderItemRepository;

    ModelMapper modelMapper = new ModelMapper();

    public OrderItemDTO getOrderItemById(int orderRequest) {
        OrderItem order = orderItemRepository.findById(orderRequest);

        OrderItemDTO orderReturn = modelMapper.map(order, OrderItemDTO.class);

        return orderReturn;
    }

    public void crearOrden(int productcod, String productname, long price, int quantity, int idsale) {
        String error = "";
        try {
            orderItemRepository.crearOrden(productcod, productname, price, quantity);
        } catch (Exception e) {
            error = e.getMessage();

        }

    }


    public List<String> consultaTopPorPorducto(String productCode) {
        String error = "";
        try {

            List<Object[]> productos = orderItemRepository.consultaTopPorPorducto(productCode);
            List<String> codigosProducos = new ArrayList<>();

            for (int i = 0; i < productos.size(); i++) {
                codigosProducos.add(productos.get(i)[0].toString());
            }
            return codigosProducos;
        } catch (Exception e) {
            error = e.getMessage();
        }
        return null;
    }
}
