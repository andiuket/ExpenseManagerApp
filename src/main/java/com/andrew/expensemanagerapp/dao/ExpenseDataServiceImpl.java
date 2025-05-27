package com.andrew.expensemanagerapp.dao;

import com.andrew.expensemanagerapp.entity.Expense;
import com.andrew.expensemanagerapp.request.ExpenseRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ExpenseDataServiceImpl implements ExpenseDao {
    @Override
    public List<Expense> getAllExpenses(int pageNumber, int pageSize) {
        return List.of();
    }

    @Override
    public Expense getExpense(Long id) {
        return null;
    }

    @Override
    public Expense addExpense(ExpenseRequest expenseRequest) {
        return null;
    }

    @Override
    public Expense updateExpense(Long id, ExpenseRequest expenseRequest) {
        return null;
    }

    @Override
    public int deleteExpense(Long id) {
        return 0;
    }

    @Override
    public List<Expense> getExpenseByCategory(String category) {
        return List.of();
    }

    @Override
    public List<Expense> getExpenseByKeyWord(String word) {
        return List.of();
    }

    @Override
    public ResponseEntity<List<Expense>> getExpenseByDate(String date) {
        return null;
    }
}
