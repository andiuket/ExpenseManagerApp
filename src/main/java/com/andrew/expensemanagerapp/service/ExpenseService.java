package com.andrew.expensemanagerapp.service;

import com.andrew.expensemanagerapp.dao.ExpenseDao;
import com.andrew.expensemanagerapp.entity.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ExpenseService {

    @Autowired
    private ExpenseDao expenseDao;


    public List<Expense> getAllExpenses(int pageNumber, int pageSize) {
        return expenseDao.getAllExpenses(pageNumber, pageSize);
    }

    public Expense getExpense(Long id) {
        return null;
    }

    public Expense addExpense(Expense expense) {
        return null;
    }

    public Expense updateExpense(Expense expense) {
        return null;
    }

    public Integer deleteExpense(Long id) {
        return -1;
    }

    public List<Expense> getExpenseByCategory(String category) {
        return null;
    }

    public List<Expense> getExpenseByKeyWord(String word) {
        return null;
    }

    public List<Expense> getExpenseByDate(String date) {
        return null;
    }
}
