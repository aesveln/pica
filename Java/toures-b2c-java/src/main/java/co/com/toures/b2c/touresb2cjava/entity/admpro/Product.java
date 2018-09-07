package co.com.toures.b2c.touresb2cjava.entity.admpro;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(schema = "ADMPRO", name = "PRODUCT")
@Getter
@Setter
public class Product {

	@Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	@Column(name="Cod")
    private String cod;
	@Column(name="Name")
    private String name;
	@Column(name="Description")
    private String description;
	@Column(name="Cost")
    private Long cost;
    @Column(name = "image_ref")
    private String imageRef;
    @Column(name = "product_type")
    private String productType;
    @JoinColumn(name = "lodging_type", referencedColumnName = "Id")
    @ManyToOne
    private Lodging lodgingType;
    @JoinColumn(name = "spectacle_type", referencedColumnName = "Id")
    @ManyToOne
    private Spectacle spectacleType;
    @JoinColumn(name = "transport_type", referencedColumnName = "Id")
    @ManyToOne
    private Transport transportType;
}
