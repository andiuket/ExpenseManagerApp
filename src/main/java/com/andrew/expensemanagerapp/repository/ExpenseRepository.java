package com.andrew.expensemanagerapp.repository;

import com.andrew.expensemanagerapp.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findExpensesByCategory(String category);

    List<Expense> findExpensesByKeyWord(String word);

    List<Expense> findExpensesByDate(String date);
}

