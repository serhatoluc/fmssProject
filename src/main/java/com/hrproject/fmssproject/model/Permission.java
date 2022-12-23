package com.hrproject.fmssproject.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Table(name = "permission")
public class Permission {

    @Id
    @SequenceGenerator(name = "permission_seq", allocationSize = 500, initialValue = 25)
    @GeneratedValue(generator = "permission_seq", strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String typeOfPermission;
    private Long totalPermission;
    private LocalDate startPermission;
    private LocalDate finishPermission;
    private String explanation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
