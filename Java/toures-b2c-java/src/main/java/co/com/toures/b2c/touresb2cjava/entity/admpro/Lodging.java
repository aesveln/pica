package co.com.toures.b2c.touresb2cjava.entity.admpro;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "ADMPRO", name = "LODGING")
@Getter
@Setter
public class Lodging {

	@Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "arrival_date")
    private Date arrivalDate;
    @Column(name = "departure_date")
    private Date departureDate;
    @Column(name = "nom_emp")
    private String nomEmp;
    @JoinColumn(name = "city", referencedColumnName = "Id")
    @ManyToOne
    private City city;
    @OneToMany(mappedBy = "lodgingType")
    @JsonIgnore
    private List<Product> productList;
}
