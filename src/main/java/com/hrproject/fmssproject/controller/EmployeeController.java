package com.hrproject.fmssproject.controller;

import com.hrproject.fmssproject.client.dto.request.CreateEmployeeRequestDto;
import com.hrproject.fmssproject.client.dto.request.UpdateEmployeeRequest;
import com.hrproject.fmssproject.client.dto.response.ResponseEmployeeDto;
import com.hrproject.fmssproject.client.dto.response.ResponseExpenseDto;
import com.hrproject.fmssproject.client.dto.response.ResponsePermissionDto;
import com.hrproject.fmssproject.client.dto.response.UpdateEmployeeResponse;
import com.hrproject.fmssproject.service.IEmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@CrossOrigin
@RequiredArgsConstructor
public class EmployeeController {
    private final IEmployeeService iEmployeeService;

    @PostMapping
    public ResponseEntity<ResponseEmployeeDto> createEmployeeDto(@Valid @RequestBody CreateEmployeeRequestDto createEmployeeRequestDto){
        return ResponseEntity.ok(iEmployeeService.createEmployee(createEmployeeRequestDto));
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<ResponseEmployeeDto> getEmployeeById(@PathVariable Integer employeeId){
        return ResponseEntity.ok(iEmployeeService.getEmployeeById(employeeId));
    }

    @GetMapping
    public ResponseEntity<List<ResponseEmployeeDto>> getAllEmployee(){
        return ResponseEntity.ok(iEmployeeService.getAllEmployee());
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployeeById (@PathVariable Integer employeeId){
        iEmployeeService.deleteEmployeeById(employeeId);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<UpdateEmployeeResponse> updateEmployee(@PathVariable Integer employeeId, @RequestBody UpdateEmployeeRequest updateEmployeeRequest){
        return ResponseEntity.ok(iEmployeeService.updateEmployee(employeeId, updateEmployeeRequest));
    }

    @GetMapping("/expense/{id}")
    public ResponseEntity<List<ResponseExpenseDto>> getExpenseByEmployeeId(@PathVariable Integer id){
        return ResponseEntity.ok(iEmployeeService.getExpenseByEmployeeId(id));
    }

    @GetMapping("/permission/{id}")
    public ResponseEntity<List<ResponsePermissionDto>> getPermissionByEmployeeId(@PathVariable Integer id){
        return ResponseEntity.ok(iEmployeeService.getPermissionByEmployeeId(id));
    }

}
