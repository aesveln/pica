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
import java.util.List;


@Entity
@Table(schema = "ADMCYO", name = "ADDRESS")
@Getter
@Setter
public class Address implements Serializable {

    public static final String ID_ADDRESS = "ID_ADDRESS";
    @Id
    @Basic(optional = false)
    @Column(name = ID_ADDRESS)
    private BigDecimal idAddress;
    @Basic(optional = false)
    @Column(name = "STREET")
    private String street;
    @Column(name = "STATE")
    private String state;
    @Column(name = "ZIP")
    private String zip;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "ADDRESS_TYPE")
    private String addressType;
    @Column(name = "CITY")
    private String city;
    @JoinTable(name = "CUSTOMER_ADDRESS", joinColumns = {
            @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ID_ADDRESS")}, inverseJoinColumns = {
            @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID_CUSTOMER")})
    @ManyToMany
    private List<Customer> customerList;


}
