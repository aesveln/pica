package co.com.toures.b2c.products.dto.admpro;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


public class CountryDTO {
    @JsonIgnore
    private int id;
    private String name;
//    @JsonIgnore
//    private List<CityDTO> cityList;

    public CountryDTO() {
    }

    public CountryDTO(int id, String name, List<CityDTO> cityList) {
        this.id = id;
        this.name = name;
//        this.cityList = cityList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<CityDTO> getCityList() {
//        return cityList;
//    }

//    public void setCityList(List<CityDTO> cityList) {
//        this.cityList = cityList;
//    }
}
