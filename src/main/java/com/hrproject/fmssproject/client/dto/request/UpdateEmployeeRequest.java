package com.hrproject.fmssproject.client.dto.request;

import com.hrproject.fmssproject.model.enums.Department;
import com.hrproject.fmssproject.model.enums.Title;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UpdateEmployeeRequest {

    private String email;
    private BigDecimal salary;
    @Enumerated(value = EnumType.STRING)
    private Title title;
    @Enumerated(value = EnumType.STRING)
    private Department department;

}
