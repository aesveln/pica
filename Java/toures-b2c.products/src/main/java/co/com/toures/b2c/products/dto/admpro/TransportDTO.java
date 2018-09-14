package co.com.toures.b2c.products.dto.admpro;

import co.com.toures.b2c.products.entity.admpro.City;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Date;
import java.util.List;



public class TransportDTO {
	
    private Integer id;
    private Date departDate;
    private Date returnDate;
    private String nomEmp;
    private String tipoTrans;
//    private CityDTO sourceCity;
//    private CityDTO targetCity;
    @JsonIgnore
    private List<ProductDTO> productList;

    public TransportDTO() {
    }

    public TransportDTO(Integer id, Date departDate, Date returnDate, String nomEmp, String tipoTrans, CityDTO sourceCity, CityDTO targetCity, List<ProductDTO> productList) {
        this.id = id;
        this.departDate = departDate;
        this.returnDate = returnDate;
        this.nomEmp = nomEmp;
        this.tipoTrans = tipoTrans;
//        this.sourceCity = sourceCity;
//        this.targetCity = targetCity;
        this.productList = productList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDepartDate() {
        return departDate;
    }

    public void setDepartDate(Date departDate) {
        this.departDate = departDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getNomEmp() {
        return nomEmp;
    }

    public void setNomEmp(String nomEmp) {
        this.nomEmp = nomEmp;
    }

    public String getTipoTrans() {
        return tipoTrans;
    }

    public void setTipoTrans(String tipoTrans) {
        this.tipoTrans = tipoTrans;
    }
//
//    public CityDTO getSourceCity() {
//        return sourceCity;
//    }
//
//    public void setSourceCity(CityDTO sourceCity) {
//        this.sourceCity = sourceCity;
//    }
//
//    public CityDTO getTargetCity() {
//        return targetCity;
//    }
//
//    public void setTargetCity(CityDTO targetCity) {
//        this.targetCity = targetCity;
//    }

    public List<ProductDTO> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductDTO> productList) {
        this.productList = productList;
    }
}
