package com.hrproject.fmssproject.client.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class CreateExpenseRequestDto {

    private String typeOfExpenditure;
    private BigDecimal expenditure;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDate dayOfExpenditure;
    private BigDecimal tax;
    private String explanation;

}
