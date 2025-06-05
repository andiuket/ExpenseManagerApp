package com.andrew.expensemanagerapp.request;


public record ExpenseRequest(
        String name,
        String description,
        Double amount,
        String category,
        String date
) {

}
