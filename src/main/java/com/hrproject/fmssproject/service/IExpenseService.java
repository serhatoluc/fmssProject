package com.hrproject.fmssproject.service;

import com.hrproject.fmssproject.client.dto.request.CreateExpenseRequestDto;
import com.hrproject.fmssproject.client.dto.response.ResponseExpenseDto;

import java.util.List;

public interface IExpenseService {
    ResponseExpenseDto createExpenseByEmployeeIdNum(Integer idNum, CreateExpenseRequestDto createExpenseRequestDto);

    List<ResponseExpenseDto> getExpenseByEmployeeId(Integer idNum);

    void deleteAllExpenseByEmployeeId(Integer idNum);

    void deleteExpenseById(Integer idNum);
}
