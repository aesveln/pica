/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.toures.b2c.touresb2cjava.entity.admcyo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Table(schema = "ADMCYO",name = "ORDER_ITEM")
@Getter
@Setter
public class OrderItem implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "PRODUCT_COD")
    private String productCod;
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Column(name = "PRICE")
    private Long price;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ID_SALES")
    @ManyToOne
    private SalesOrder orderId;
}
