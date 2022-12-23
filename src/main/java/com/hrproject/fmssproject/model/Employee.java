package com.hrproject.fmssproject.model;


import com.fasterxml.jackson.annotation.JsonFormat;
//import com.hrproject.fmssproject.model.enums.Department;
import com.hrproject.fmssproject.model.enums.Department;
import com.hrproject.fmssproject.model.enums.Title;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

@Data
@ToString
@EqualsAndHashCode
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class Employee {

    @Id
    @SequenceGenerator(name = "employee_seq", allocationSize = 100, initialValue = 2)
    @GeneratedValue(generator = "employee_seq", strategy = GenerationType.SEQUENCE)
    @Column(name="employee_id")
    private Integer id;

    private String name;
    private String lastName;
    private String email;
    private Long identificationNumber;
    private BigDecimal salary;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDate dateOfParticipation;
    @Enumerated
    private Title title;
    @Enumerated
    private Department department;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDate birthDate;

    @ToString.Exclude
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Expense> expenseList;

    @ToString.Exclude
    @OneToOne(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Address address;

    @ToString.Exclude
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Permission> permissionList;
}
