package com.hrproject.fmssproject.service;

import com.hrproject.fmssproject.client.dto.request.CreateEmployeeRequestDto;
import com.hrproject.fmssproject.client.dto.request.UpdateEmployeeRequest;
import com.hrproject.fmssproject.client.dto.response.ResponseEmployeeDto;
import com.hrproject.fmssproject.client.dto.response.ResponseExpenseDto;
import com.hrproject.fmssproject.client.dto.response.ResponsePermissionDto;
import com.hrproject.fmssproject.client.dto.response.UpdateEmployeeResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEmployeeService {
    ResponseEmployeeDto createEmployee(CreateEmployeeRequestDto createEmployeeRequestDto);

    ResponseEmployeeDto getEmployeeById(Integer employeeId);

    List<ResponseEmployeeDto> getAllEmployee();

    void deleteEmployeeById(Integer employeeId);

    UpdateEmployeeResponse updateEmployee(Integer employeeId, UpdateEmployeeRequest updateEmployeeRequest);

    List<ResponseExpenseDto> getExpenseByEmployeeId(Integer id);

    List<ResponsePermissionDto> getPermissionByEmployeeId(Integer id);
}
