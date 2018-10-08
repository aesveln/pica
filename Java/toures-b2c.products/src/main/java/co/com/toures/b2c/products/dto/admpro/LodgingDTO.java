package co.com.toures.b2c.products.dto.admpro;

import co.com.toures.b2c.products.entity.admpro.City;
import co.com.toures.b2c.products.utils.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.List;

public class LodgingDTO {

    private Integer id;
    private Date arrivalDate;
    private Date departureDate;
    private String nomEmp;
    //    private CityDTO city;
    @JsonIgnore
    private List<ProductDTO> productList;


    public LodgingDTO() {
    }

    public LodgingDTO(Integer id, Date arrivalDate, Date departureDate, String nomEmp, CityDTO city, List<ProductDTO> productList) {
        this.id = id;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.nomEmp = nomEmp;
//        this.city = city;
        this.productList = productList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public String getNomEmp() {
        return nomEmp;
    }

    public void setNomEmp(String nomEmp) {
        this.nomEmp = nomEmp;
    }
//
//    public CityDTO getCity() {
//        return city;
//    }
//
//    public void setCity(CityDTO city) {
//        this.city = city;
//    }

    public List<ProductDTO> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductDTO> productList) {
        this.productList = productList;
    }
}
