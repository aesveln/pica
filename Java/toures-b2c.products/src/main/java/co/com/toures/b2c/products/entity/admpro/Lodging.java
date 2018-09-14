package co.com.toures.b2c.products.entity.admpro;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

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
//    @JoinColumn(name = "city", referencedColumnName = "Id")
//    @ManyToOne (fetch = FetchType.LAZY)
//    private City city;
//    @OneToMany(mappedBy = "lodgingType", fetch = FetchType.LAZY)
//    @JsonIgnore
//    private List<Product> productList;
}
