package com.andrew.expensemanagerapp.dto;

public record ExpenseDto(
        String name,
        String description,
        Double amount,
        String category,
        String date
) {

}
