package com.andrew.expensemanagerapp.controller;

import com.andrew.expensemanagerapp.entity.Expense;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseController {


    @GetMapping("")
    public List<Expense> getAllExpenses(@RequestParam int pageNumber, @RequestParam int pageSize){
        return null;
    }

    @GetMapping("/{id}")
    public Expense getExpense(@PathVariable Long id){
        return null;
    }

    @PostMapping("")
    public Expense addExpense(@Validated @RequestBody Expense expense){
        return null;
    }

    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
        return null;
    }

    @DeleteMapping("/{id}")
    public int deleteExpense(@PathVariable Long id){
        return 0;
    }

    @GetMapping("/filterbyCategory")
    public ResponseEntity<List<Expense>> getExpenseByCategory(@RequestParam String category){
        return null;
    }

    @GetMapping("/filterbykeyword")
    public ResponseEntity<List<Expense>> getExpenseByKeyWord(@RequestParam String word){
        return null;
    }

    @GetMapping("/filterByDate")
    public ResponseEntity<List<Expense>> getExpenseByDate(@RequestParam String date){
        return null;
    }
}
