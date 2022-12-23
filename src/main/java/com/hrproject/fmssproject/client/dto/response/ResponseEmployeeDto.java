package com.hrproject.fmssproject.client.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hrproject.fmssproject.model.enums.Department;
import com.hrproject.fmssproject.model.enums.Title;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ResponseEmployeeDto {

    private String name;
    private Integer id;
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


}
