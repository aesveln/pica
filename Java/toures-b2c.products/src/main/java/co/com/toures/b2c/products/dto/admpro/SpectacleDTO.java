package co.com.toures.b2c.products.dto.admpro;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Date;
import java.util.List;


public class SpectacleDTO {
	
    private Integer id;
    private String type;
    private Date spectacleDate;
    private String nomEmp;
    @JsonIgnore
    private List<ProductDTO> productList;
//    private CityDTO city;

    public SpectacleDTO() {
    }

    public SpectacleDTO(Integer id, String type, Date spectacleDate, String nomEmp, List<ProductDTO> productList, CityDTO city) {
        this.id = id;
        this.type = type;
        this.spectacleDate = spectacleDate;
        this.nomEmp = nomEmp;
        this.productList = productList;
//        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getSpectacleDate() {
        return spectacleDate;
    }

    public void setSpectacleDate(Date spectacleDate) {
        this.spectacleDate = spectacleDate;
    }

    public String getNomEmp() {
        return nomEmp;
    }

    public void setNomEmp(String nomEmp) {
        this.nomEmp = nomEmp;
    }

    public List<ProductDTO> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductDTO> productList) {
        this.productList = productList;
    }
//
//    public CityDTO getCity() {
//        return city;
//    }
//
//    public void setCity(CityDTO city) {
//        this.city = city;
//    }
}
