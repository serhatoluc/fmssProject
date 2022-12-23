package com.hrproject.fmssproject.service.impl;

import com.hrproject.fmssproject.client.dto.request.CreateExpenseRequestDto;
import com.hrproject.fmssproject.client.dto.response.ResponseExpenseDto;
import com.hrproject.fmssproject.exception.employee.EmployeeNotFoundException;
import com.hrproject.fmssproject.exception.expence.ExpenseNotFoundException;
import com.hrproject.fmssproject.mapper.ExpenseMapper;
import com.hrproject.fmssproject.model.Employee;
import com.hrproject.fmssproject.model.Expense;
import com.hrproject.fmssproject.repository.EmployeeRepository;
import com.hrproject.fmssproject.repository.ExpenseRepository;
import com.hrproject.fmssproject.service.IExpenseService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService implements IExpenseService {

    private final ExpenseRepository expenseRepository;
    private final ExpenseMapper expenseMapper;
    private final EmployeeRepository employeeRepository;

    @Override
    public ResponseExpenseDto createExpenseByEmployeeIdNum(Integer idNum, CreateExpenseRequestDto createExpenseRequestDto) {
        Employee employee = employeeRepository.findById(idNum).orElseThrow(() -> new EmployeeNotFoundException("Harcamaya Ait Kullanici Bulunamadi!"));
        Expense expense = expenseMapper.toExpenseFromCreateExpenseRequest(createExpenseRequestDto);
        List<Expense> expenseList = new ArrayList<>();
        expense.setEmployee(employee);
        expenseList.add(expense);
        employee.setExpenseList(expenseList);
        expenseRepository.save(expense);
        return expenseMapper.toResponseExpenseFromCreateExpenseRequest(createExpenseRequestDto);
    }

    @Override
    public List<ResponseExpenseDto> getExpenseByEmployeeId(Integer idNum) {
        return expenseMapper.toListExpenseResponseFromListExpense(employeeRepository.findById(idNum).orElseThrow(
                ()-> new EmployeeNotFoundException("Harcamaya Ait Kullanici Bulunamadi!")
        ).getExpenseList());
    }

    @Override
    @Transactional
    public void deleteAllExpenseByEmployeeId(Integer idNum) {
        if(!employeeRepository.existsById(idNum)){
            throw new EmployeeNotFoundException("Silmek istediginiz harcama kaydina ulasilamiyor!");
        }else
            expenseRepository.deleteExpenseByEmployeeId(idNum);
    }

    @Override
    public void deleteExpenseById(Integer idNum) {
        if(!expenseRepository.existsById(idNum)){
            throw new ExpenseNotFoundException("Silmek istediginiz harcama kaydina ulasilamiyor!");
        }else
            expenseRepository.deleteById(idNum);

    }
}
