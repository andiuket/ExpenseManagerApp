package com.andrew.expensemanagerapp.io;


public record ExpenseRequest(
        String name,
        String description,
        Double amount,
        String category,
        String date
) {

}
