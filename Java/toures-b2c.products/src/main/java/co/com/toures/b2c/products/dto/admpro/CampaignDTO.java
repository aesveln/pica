package co.com.toures.b2c.products.dto.admpro;

import co.com.toures.b2c.products.utils.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.sql.Date;


public class CampaignDTO {

    private long id;
    private String imageRef;
    private ProductDTO product;
    private Date fromDate;
    private Date toDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImageRef() {
        return imageRef;
    }

    public void setImageRef(String imageRef) {
        this.imageRef = imageRef;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }
    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }
    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }



}
