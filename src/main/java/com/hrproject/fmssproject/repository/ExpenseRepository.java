package com.hrproject.fmssproject.repository;

import com.hrproject.fmssproject.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
    List<Expense> findExpenseByEmployeeId(Integer id);
    void deleteExpenseByEmployeeId(Integer employeeId);

}
