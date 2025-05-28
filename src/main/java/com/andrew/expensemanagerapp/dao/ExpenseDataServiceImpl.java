package com.andrew.expensemanagerapp.dao;

import com.andrew.expensemanagerapp.entity.Expense;
import com.andrew.expensemanagerapp.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class ExpenseDataServiceImpl implements ExpenseDao {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public List<Expense> getAllExpenses(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.DESC);
        return expenseRepository.findAll(pageable).getContent();
    }

    @Override
    public Optional<Expense> getExpense(Long id) {
        return expenseRepository.findById(id);
    }

    @Override
    public Expense addExpense(Expense expense) {
        return null;
    }

    @Override
    public Expense updateExpense(Long id, Expense expense) {
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
