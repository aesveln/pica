package co.com.toures.b2c.products.entity.admpro;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(schema = "ADMPRO", name = "SPECTACLE")
@Getter
@Setter
public class Spectacle {
	
	@Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	@Column(name="Type")
    private String type;
    @Column(name = "spectacle_date")
    private Date spectacleDate;
    @Column(name = "nom_emp")
    private String nomEmp;
//    @OneToMany(mappedBy = "spectacleType", fetch = FetchType.LAZY)
//    @JsonIgnore
//    private List<Product> productList;
//    @JoinColumn(name = "city", referencedColumnName = "Id")
//    @ManyToOne (fetch = FetchType.LAZY)
//    private City city;

}
