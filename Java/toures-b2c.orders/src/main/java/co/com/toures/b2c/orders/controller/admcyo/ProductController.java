package co.com.toures.b2c.orders.controller.admcyo;

import co.com.toures.b2c.orders.service.OrderItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api("Set of endpoints for retrieving top products")
public class ProductController {
	
	@Autowired
	private OrderItemService orderService;
	


	@RequestMapping(method = RequestMethod.GET, value =  "/product/top-product/{cod}", produces = "application/json")
	@ApiOperation("Get top 5 product by product")
	public List<String> consultaTopPorPorducto(@PathVariable String cod)
	{
		return orderService.consultaTopPorPorducto(cod);
	}
	
	

}
