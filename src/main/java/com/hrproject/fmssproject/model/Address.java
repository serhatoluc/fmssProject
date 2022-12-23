package com.hrproject.fmssproject.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "address")
public class Address {

    @Id
    @SequenceGenerator(name = "address_seq", allocationSize = 1000, initialValue = 5)
    @GeneratedValue(generator = "address_seq", strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String addressLine;
    private String city;
    private Long phoneNumber;
    private String country;
    private String postalCode;


    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
