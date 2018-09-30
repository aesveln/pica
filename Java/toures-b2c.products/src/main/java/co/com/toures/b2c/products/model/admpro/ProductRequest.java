package co.com.toures.b2c.products.model.admpro;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;


public class ProductRequest {


    @NotNull
    @NotBlank
    private int pageSize;
    @NotNull
    @NotBlank
    private int pageNumber;
    private String sortBy;

    private String spectacleDate;
    private String return_date;

    private String arrivalDate;
    private String departureDate;


    public ProductRequest() {
    }


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getSpectacleDate() {
        return spectacleDate;
    }

    public void setSpectacleDate(String spectacleDate) {
        this.spectacleDate = spectacleDate;
    }


    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }
}
