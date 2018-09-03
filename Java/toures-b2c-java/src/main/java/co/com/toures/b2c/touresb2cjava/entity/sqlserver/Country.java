package co.com.toures.b2c.touresb2cjava.entity.sqlserver;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(schema = "ADMPRO", name = "COUNTRY")
@Getter
@Setter
public class Country {


    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;


    public Country(String name) {
        this.name = name;
    }
}
