package co.com.toures.b2c.touresb2cjava.entity.admpro;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(schema = "ADMPRO", name = "CITY")
@Getter
@Setter
public class City {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "country", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;


}