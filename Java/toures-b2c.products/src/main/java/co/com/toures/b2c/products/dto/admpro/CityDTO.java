package co.com.toures.b2c.products.dto.admpro;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class CityDTO {

    private int id;
    private String name;
//    private CountryDTO country;

    public CityDTO() {
    }

    public CityDTO(int id, String name, CountryDTO country) {
        this.id = id;
        this.name = name;
//        this.country = country;
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
//
//    public CountryDTO getCountry() {
//        return country;
//    }
//
//    public void setCountry(CountryDTO country) {
//        this.country = country;
//    }
}