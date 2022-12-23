package com.hrproject.fmssproject.exception.expence;

public class ExpenseNotFoundException extends RuntimeException{
    public ExpenseNotFoundException (String messege){
        super(messege);
    }
}
