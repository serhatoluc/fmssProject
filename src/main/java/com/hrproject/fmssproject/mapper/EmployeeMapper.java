package com.hrproject.fmssproject.mapper;

import com.hrproject.fmssproject.client.dto.request.CreateEmployeeRequestDto;
import com.hrproject.fmssproject.client.dto.request.UpdateEmployeeRequest;
import com.hrproject.fmssproject.client.dto.response.ResponseEmployeeDto;
import com.hrproject.fmssproject.client.dto.response.UpdateEmployeeResponse;
import com.hrproject.fmssproject.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.aop.TargetSource;


@Mapper(implementationName = "EmployeeMapperImpl" , componentModel = "spring")
public interface EmployeeMapper {

    Employee toEmployeeFromCreateEmployeeRequestDto(CreateEmployeeRequestDto createEmployeeRequestDto);
    Employee toEmployeeFromUpdateEmployeeRequest (UpdateEmployeeRequest updateEmployeeRequest);
    ResponseEmployeeDto toResponseEmployeeDtoFromCreateEmployeeRequestDto(CreateEmployeeRequestDto createEmployeeRequestDto);
    ResponseEmployeeDto toResponseEmployeeDtoFromEmployee (Employee employee);
    UpdateEmployeeResponse toUpdateEmployeeResponseFromUpdateEmployeeRequest (UpdateEmployeeRequest updateEmployeeRequest);

    @Mapping(target = ".", source = ".", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    Employee updateEmployee(@MappingTarget Employee employee, UpdateEmployeeRequest employeeRequest);

}
