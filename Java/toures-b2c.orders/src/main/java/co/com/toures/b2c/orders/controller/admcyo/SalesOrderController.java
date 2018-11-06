package co.com.toures.b2c.orders.controller.admcyo;

import java.io.File;
import java.io.PrintWriter;
import java.math.BigDecimal;

import co.com.toures.b2c.orders.service.QueueContabilidadService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import co.com.toures.b2c.orders.dto.admcyo.SalesOrderDTO;
import co.com.toures.b2c.orders.model.admcyo.SaleOrderCancelResponse;
import co.com.toures.b2c.orders.model.admcyo.SalesOrderRequest;
import co.com.toures.b2c.orders.model.admcyo.SalesOrderResponse;
import co.com.toures.b2c.orders.service.SalesOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api("Set of endpoints for retrieving salesOrders")
public class SalesOrderController {

    @Autowired
    private SalesOrderService salesService;


    ModelMapper modelMapper = new ModelMapper();


    static final String URL_HOTELES = "http://192.168.1.100:8087/HotelDann";
    static final String URL_EVENTO = "http://192.168.1.100:8087/TuBoleta";

    @RequestMapping(method = RequestMethod.POST, value = "/salesorder/salesOrderStatus", produces = "application/json")
    @ApiOperation("Return all sales by status")
    public ResponseEntity<SalesOrderResponse> getSalesByStatus(@RequestBody SalesOrderRequest saleRequest) {
        SalesOrderResponse response = new SalesOrderResponse();

        response.setSales(salesService.findSalesByStatus(saleRequest.getStatus()));

        return ResponseEntity.ok(response);

    }


    @RequestMapping(method = RequestMethod.GET, value = "/salesorder/salesorderOpen/{idcustomer}", produces = "application/json")
    //@GetMapping("/salesorder/salesorderOpen/{idcustomer}")
    @ApiOperation("Return all sales open")
    public ResponseEntity<SalesOrderResponse> getSalesOpen(@PathVariable(value = "idcustomer") int idcustomer) {
        SalesOrderResponse response = new SalesOrderResponse();
        response.setSales(salesService.findOpenSales(idcustomer));
        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/salesorder/cancelSaleOrder/{idsale}", produces = "application/json")
    @ApiOperation("cancel a sale")
    public ResponseEntity cancelSale(@PathVariable(value = "idsale") int idsale) {
        RestTemplate restTemplate = new RestTemplate();
        SaleOrderCancelResponse salecancelrequest = new SaleOrderCancelResponse();
        int salecancel;
        String ret = "";
        File bolivariano = new File("CanceladasBolivariano.txt");
        File hilton = new File("CanceladasHilton.txt");

        try {

            if (!bolivariano.exists()) {
                bolivariano.createNewFile();
            }

            if (!hilton.exists()) {
                hilton.createNewFile();
            }

            PrintWriter pw = new PrintWriter(bolivariano);
            pw.println("Se cancela reserva del cliente: " + idsale);
            pw.close();

            PrintWriter pw2 = new PrintWriter(hilton);
            pw2.println("Se cancela reserva del cliente: " + idsale);
            pw2.close();

            //POST METHOD
            String resultHoteles = restTemplate.postForObject(URL_HOTELES, idsale, String.class);
            String resultEvento = restTemplate.postForObject(URL_EVENTO, idsale, String.class);

            //Servicios SOAP
            String respSOAPAmerican = salesService.getRespuestaServicioAvianca(idsale);
            salecancel = salesService.cancelSales(idsale);

            if (salecancel == 0) {
                ret = "La orden no puede ser cancelada";
            } else {
                ret = "Orden cancelada";

            }


        } catch (Exception e) {
            ret = "Error " + e.getMessage();
        }

        salecancelrequest.setRespuesta(ret);
        return ResponseEntity.ok(salecancelrequest);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/salesorder/salesCliente/", produces = "application/json")
    @ApiOperation("Return all sales by client id")
    public ResponseEntity<SalesOrderResponse> getSalesforClient(@RequestBody SalesOrderRequest saleRequest) {
        SalesOrderResponse response = new SalesOrderResponse();
        response.setSales(salesService.ordenesClientes(saleRequest.getIdcustomer().intValue()));
        return ResponseEntity.ok(response);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/salesorder/saleOrder/{idorder}", produces = "application/json")
    @ApiOperation("Return detailed order")
    public SalesOrderDTO getSalesOrderDetail(@PathVariable(value = "idorder") BigDecimal idorder) {
        try {

            return salesService.findDetailSalesOrder(idorder);

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

//	@RequestMapping(method = RequestMethod.POST, value =  "/salesorder/detallesOrders", produces = "application/json")
//	@ApiOperation("Return all order items for a sale")
//	public  ResponseEntity <OrderItemResponse> getDetalleOrder (@RequestBody OrderItemRequest orderRequest)
//	{
//		OrderItemResponse response = new OrderItemResponse();
//		
//		response.setListOrdenes(salesService.detalleOrderItem(orderRequest.getIdsale()));
//		
//		return ResponseEntity.ok(response);
//		
//	}
}
