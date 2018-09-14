package co.com.toures.b2c.products.entity.admpro;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;


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
//    @JoinColumn(name = "source_city", referencedColumnName = "Id")
//    @ManyToOne (fetch = FetchType.LAZY)
//    private City sourceCity;
//    @JoinColumn(name = "target_city", referencedColumnName = "Id")
//    @ManyToOne (fetch = FetchType.LAZY)
//    private City targetCity;
//    @OneToMany(mappedBy = "transportType", fetch = FetchType.LAZY)
//    @JsonIgnore
//    private List<Product> productList;

}
