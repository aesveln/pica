package co.com.toures.b2c.products.entity.admpro;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "ADMPRO", name = "CAMPAIGN")
@Getter
@Setter
public class Campaign {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "image_ref")
    private String imageRef;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product", nullable = false)
    private Product product;
    @Column(name = "date_from")
    private Date fromDate;
    @Column(name = "date_to")
    private Date toDate;




}
