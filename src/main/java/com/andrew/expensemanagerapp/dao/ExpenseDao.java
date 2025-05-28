package com.andrew.expensemanagerapp.dao;

import com.andrew.expensemanagerapp.entity.Expense;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

public interface ExpenseDao {

    List<Expense> getAllExpenses(int pageNumber, int pageSize);
    Optional<Expense> getExpense(Long id);
    Expense addExpense(Expense expense);
    Expense updateExpense(Long id, Expense expense);
    int deleteExpense(Long id);
    List<Expense> getExpenseByCategory(String category);
    List<Expense> getExpenseByKeyWord(String word);
    ResponseEntity<List<Expense>> getExpenseByDate(String date);
}
