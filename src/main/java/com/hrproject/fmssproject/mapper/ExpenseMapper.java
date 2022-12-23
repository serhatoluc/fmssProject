package com.hrproject.fmssproject.mapper;

import com.hrproject.fmssproject.client.dto.request.CreateExpenseRequestDto;
import com.hrproject.fmssproject.client.dto.response.ResponseExpenseDto;
import com.hrproject.fmssproject.model.Expense;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(implementationName = "ExpenseMapperImpl", componentModel = "spring")
public interface ExpenseMapper {

    List<ResponseExpenseDto> toListExpenseResponseFromListExpense(List<Expense> expenseList);

    ResponseExpenseDto toResponseExpenseFromCreateExpenseRequest (CreateExpenseRequestDto createExpenseRequest);

    Expense toExpenseFromCreateExpenseRequest(CreateExpenseRequestDto createExpenseRequest);

    List<ResponseExpenseDto> toListResponseExpenseListFromListExpense(List<Expense> expenseList);
}
