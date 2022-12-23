package com.hrproject.fmssproject.repository;

import com.hrproject.fmssproject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//    Employee findEmployeeByIdentificationNumber(Integer idNum);
}
