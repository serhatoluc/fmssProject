package com.hrproject.fmssproject.controller;

import com.hrproject.fmssproject.client.dto.request.CreateExpenseRequestDto;
import com.hrproject.fmssproject.client.dto.response.ResponseExpenseDto;
import com.hrproject.fmssproject.service.IExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee/expenses")
@CrossOrigin
@RequiredArgsConstructor
public class ExpenseController {

    private final IExpenseService iExpenseService;

    @PostMapping("/{idNum}")
    public ResponseEntity<ResponseExpenseDto> createExpenseByEmployeeIdNum(@PathVariable Integer idNum,
                                                                           @RequestBody CreateExpenseRequestDto createExpenseRequestDto){
        return ResponseEntity.ok(iExpenseService.createExpenseByEmployeeIdNum(idNum, createExpenseRequestDto));
    }

    @GetMapping("/{idNum}")
    public ResponseEntity<List<ResponseExpenseDto>> getExpenseByEmployeeId(@PathVariable Integer idNum){
        return ResponseEntity.ok(iExpenseService.getExpenseByEmployeeId(idNum));
    }

    // Bu method deneme icin yazildi.
    @DeleteMapping("/all/{idNum}")
    public void deleteAllExpenseByEmployeeId(@PathVariable Integer idNum){
        iExpenseService.deleteAllExpenseByEmployeeId(idNum);
    }

    @DeleteMapping("/{idNum}")
    public void deleteExpenseById(@PathVariable Integer idNum){
        iExpenseService.deleteExpenseById(idNum);
    }

}
