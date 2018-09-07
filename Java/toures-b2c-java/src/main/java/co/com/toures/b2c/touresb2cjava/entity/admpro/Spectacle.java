package co.com.toures.b2c.touresb2cjava.entity.admpro;


import java.sql.Date;
import java.util.List;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

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
    @OneToMany(mappedBy = "spectacleType")
    @JsonIgnore
    private List<Product> productList;
    @JoinColumn(name = "city", referencedColumnName = "Id")
    @ManyToOne
    private City city;

}
