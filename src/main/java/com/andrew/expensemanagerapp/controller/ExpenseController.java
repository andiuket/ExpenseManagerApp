package com.andrew.expensemanagerapp.controller;

import com.andrew.expensemanagerapp.entity.Expense;
import com.andrew.expensemanagerapp.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;


    @GetMapping("/expenses")
    public ResponseEntity<List<Expense>> getAllExpenses(@RequestParam int pageNumber, @RequestParam int pageSize){
        List<Expense> expenses = expenseService.getAllExpenses(pageNumber, pageSize);
        if(expenses != null){
            return new ResponseEntity<List<Expense>>(expenseService.getAllExpenses(pageNumber, pageSize), HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpense(@PathVariable Long id){
        Expense expense = expenseService.getExpense(id);
        if(expense != null ){
            return new ResponseEntity<>(expenseService.getExpense(id), HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);

    }

    @PostMapping("")
    public ResponseEntity<Expense> addExpense(@Validated @RequestBody Expense expense){
        Expense newExpense = expenseService.addExpense(expense);
        if(newExpense != null ){
            return new ResponseEntity<>(expenseService.addExpense(expense), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
        Expense updateExpense = expenseService.updateExpense(expense);
        if(updateExpense != null ){
            return new ResponseEntity<>("Update was successful", HttpStatus.OK);
        }
        return new ResponseEntity<>("Update wasn't successful", HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteExpense(@PathVariable Long id){
        Integer status = expenseService.deleteExpense(id);
        if(status == 1){
            return new ResponseEntity<>(expenseService.deleteExpense(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(expenseService.deleteExpense(id), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/filterbyCategory")
    public ResponseEntity<List<Expense>> getExpenseByCategory(@RequestParam String category){
        return new ResponseEntity<List<Expense>>(expenseService.getExpenseByCategory(category), HttpStatus.OK);
    }

    @GetMapping("/filterbykeyword")
    public ResponseEntity<List<Expense>> getExpenseByKeyWord(@RequestParam String word){
        return new ResponseEntity<List<Expense>>(expenseService.getExpenseByKeyWord(word), HttpStatus.OK);
    }

    @GetMapping("/filterByDate")
    public ResponseEntity<List<Expense>> getExpenseByDate(@RequestParam String date){
        return new ResponseEntity<List<Expense>>(expenseService.getExpenseByDate(date), HttpStatus.OK);
    }
}
