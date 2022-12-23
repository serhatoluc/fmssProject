package com.hrproject.fmssproject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "expense")
public class Expense {

    @Id
    @SequenceGenerator(name = "expense_seq", allocationSize = 250, initialValue = 10)
    @GeneratedValue(generator = "expense_seq", strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String typeOfExpenditure;
    private BigDecimal expenditure;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private Date dayOfExpenditure;
    private BigDecimal tax;
    private String explanation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
