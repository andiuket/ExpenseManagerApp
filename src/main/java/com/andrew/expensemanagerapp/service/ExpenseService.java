package com.andrew.expensemanagerapp.service;


import com.andrew.expensemanagerapp.dto.ExpenseDto;
import com.andrew.expensemanagerapp.entity.Expense;
import com.andrew.expensemanagerapp.repository.ExpenseRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ExpenseService {

    private ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }


    public List<Expense> getAllExpenses(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.DESC);
        return expenseRepository.findAll(pageable).getContent();
    }

    public Expense getExpense(Long id) {
        return null;
    }

    public Expense addExpense(ExpenseDto expenseDto) {
        return null;
    }

    public Expense updateExpense(ExpenseDto expenseDto) {
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
