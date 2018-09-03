package co.com.toures.b2c.touresb2cjava.entity.sqlserver;


import javax.persistence.*;

@Entity
@Table(schema = "ADMPRO",name = "CITY")
public class City {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String cost;
    private long country;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }


    public long getCountry() {
        return country;
    }

    public void setCountry(long country) {
        this.country = country;
    }

}