package com.andrew.expensemanagerapp.dao;

import com.andrew.expensemanagerapp.entity.Expense;
import com.andrew.expensemanagerapp.request.ExpenseRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ExpenseDao {

    List<Expense> getAllExpenses(int pageNumber, int pageSize);

    Expense getExpense(Long id);

    Expense addExpense(ExpenseRequest expenseRequest);

    Expense updateExpense(Long id, ExpenseRequest expenseRequest);

    int deleteExpense(Long id);

    List<Expense> getExpenseByCategory(String category);

    List<Expense> getExpenseByKeyWord(String word);

    ResponseEntity<List<Expense>> getExpenseByDate(String date);
}
