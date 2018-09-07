package co.com.toures.b2c.touresb2cjava.entity.admpro;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(schema = "ADMPRO", name = "TRANSPORT")
@Getter
@Setter
public class Transport {
	
	@Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "depart_date")
    private Date departDate;
    @Column(name = "return_date")
    private Date returnDate;
    @Column(name = "nom_emp")
    private String nomEmp;
    @Column(name = "tipo_trans")
    private String tipoTrans;
    @JoinColumn(name = "source_city", referencedColumnName = "Id")
    @ManyToOne
    private City sourceCity;
    @JoinColumn(name = "target_city", referencedColumnName = "Id")
    @ManyToOne
    private City targetCity;
    @OneToMany(mappedBy = "transportType")
    @JsonIgnore
    private List<Product> productList;

}
