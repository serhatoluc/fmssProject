package com.hrproject.fmssproject.service.impl;

import com.hrproject.fmssproject.client.dto.request.CreateEmployeeRequestDto;
import com.hrproject.fmssproject.client.dto.request.UpdateEmployeeRequest;
import com.hrproject.fmssproject.client.dto.response.ResponseEmployeeDto;
import com.hrproject.fmssproject.client.dto.response.ResponseExpenseDto;
import com.hrproject.fmssproject.client.dto.response.ResponsePermissionDto;
import com.hrproject.fmssproject.client.dto.response.UpdateEmployeeResponse;
import com.hrproject.fmssproject.exception.employee.EmployeeNotFoundException;
import com.hrproject.fmssproject.mapper.AddressMapper;
import com.hrproject.fmssproject.mapper.EmployeeMapper;
import com.hrproject.fmssproject.mapper.ExpenseMapper;
import com.hrproject.fmssproject.mapper.PermissionMapper;
import com.hrproject.fmssproject.model.Address;
import com.hrproject.fmssproject.model.Employee;
import com.hrproject.fmssproject.model.Expense;
import com.hrproject.fmssproject.model.Permission;
import com.hrproject.fmssproject.repository.AddressRepository;
import com.hrproject.fmssproject.repository.EmployeeRepository;
import com.hrproject.fmssproject.repository.ExpenseRepository;
import com.hrproject.fmssproject.repository.PermissionRepository;
import com.hrproject.fmssproject.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService {

    private final EmployeeRepository employeeRepository;
    private final AddressRepository addressRepository;
    private final EmployeeMapper employeeMapper;
    private final ExpenseMapper expenseMapper;
    private final AddressMapper addressMapper;
    private final ExpenseRepository  expenseRepository;
    private final PermissionRepository permissionRepository;
    private final PermissionMapper permissionMapper;

    @Override
    public ResponseEmployeeDto createEmployee(CreateEmployeeRequestDto createEmployeeRequestDto) {
        Employee employee = employeeMapper.toEmployeeFromCreateEmployeeRequestDto(createEmployeeRequestDto);
        Address address = addressMapper.toAddressFromCreateEmployeeRequestDto(createEmployeeRequestDto);
        address.setEmployee(employee);
        employeeRepository.save(employee);
        addressRepository.save(address);
        return employeeMapper.toResponseEmployeeDtoFromCreateEmployeeRequestDto(createEmployeeRequestDto);
    }

    @Override
    public ResponseEmployeeDto getEmployeeById(Integer employeeId) {
        return employeeRepository.findById(employeeId)
                .map(employeeMapper::toResponseEmployeeDtoFromEmployee)
                .orElseThrow(() -> new EmployeeNotFoundException("Kullanici Bulunamadi"));
    }

    @Override
    public List<ResponseEmployeeDto> getAllEmployee() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::toResponseEmployeeDtoFromEmployee)
                .toList();
    }

    @Override
    public void deleteEmployeeById(Integer employeeId) {
        if(employeeRepository.findById(employeeId).isPresent()){
            employeeRepository.deleteById(employeeId);
        }else
            throw new EmployeeNotFoundException("Kullanici Bulunamiyor!");
    }

    @Override
    public UpdateEmployeeResponse updateEmployee(Integer employeeId, UpdateEmployeeRequest updateEmployeeRequest) {
        employeeRepository
                .save(employeeMapper.updateEmployee(employeeRepository.findById(employeeId)
                        .orElseThrow(() -> new EmployeeNotFoundException("Aradiginiz kullanici bulunamadi!")), updateEmployeeRequest));
        return employeeMapper.toUpdateEmployeeResponseFromUpdateEmployeeRequest(updateEmployeeRequest);
    }


    @Override
    public List<ResponseExpenseDto> getExpenseByEmployeeId(Integer id) {
        List<Expense> expenseList = expenseRepository.findExpenseByEmployeeId(id);
        return expenseMapper.toListExpenseResponseFromListExpense(expenseList);
    }

    @Override
    public List<ResponsePermissionDto> getPermissionByEmployeeId(Integer id) {
        List<Permission> permissions = permissionRepository.findAll();
        return permissionMapper.toListResponsePermissionFromListPermission(permissions);
    }
}
