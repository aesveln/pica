package co.com.toures.b2c.touresb2cjava.entity.admpro;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

import java.util.List;


@Entity
@Table(schema = "ADMPRO",name = "COUNTRY")
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Country {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "country",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<City> cityList;

}
