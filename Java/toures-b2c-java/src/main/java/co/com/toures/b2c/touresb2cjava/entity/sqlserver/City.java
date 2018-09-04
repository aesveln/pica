package co.com.toures.b2c.touresb2cjava.entity.sqlserver;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(schema = "ADMPRO",name = "CITY")
@Getter
@Setter
public class City {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String cost;
    private long country;

    public City(String name, String cost, long country) {
        this.name = name;
        this.cost = cost;
        this.country = country;
    }
}