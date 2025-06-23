package com.andrew.expensemanagerapp.controller;

import com.andrew.expensemanagerapp.io.ExpenseRequest;
import com.andrew.expensemanagerapp.entity.Expense;
import com.andrew.expensemanagerapp.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }


    @GetMapping("/expenses")
    public ResponseEntity<List<Expense>> getAllExpenses(
            @RequestParam(defaultValue = "0") int pNum,
            @RequestParam(defaultValue = "5") int pSize,
            @RequestParam(defaultValue = "asc") String dir,
            @RequestParam(defaultValue = "is") String sortBy
    ){
        List<Expense> expenses = expenseService.getAllExpenses(pNum, pSize, dir, sortBy);
        if(expenses != null){
            return new ResponseEntity<List<Expense>>(expenseService.getAllExpenses(pNum, pSize, dir, sortBy), HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

    @GetMapping("/expense/{id}")
    public ResponseEntity<Expense> getExpense(@PathVariable Long id){
        Expense expense = expenseService.getExpense(id);
        if(expense != null ){
            return new ResponseEntity<>(expenseService.getExpense(id), HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);

    }

    @PostMapping("/expenses")
    public ResponseEntity<Expense> addExpense(@Validated @RequestBody ExpenseRequest request){
        Expense newExpense = expenseService.addExpense(request);
        if(newExpense != null ){
            return new ResponseEntity<>(newExpense, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/expense/{id}")
    public ResponseEntity<String> updateExpense(@PathVariable Long id, @RequestBody ExpenseRequest request) {
        Expense updateExpense = expenseService.updateExpense( id,request);
        if(updateExpense != null ){
            return new ResponseEntity<>("Update was successful", HttpStatus.OK);
        }
        return new ResponseEntity<>("Update wasn't successful", HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/expense/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id){
        expenseService.deleteExpense(id);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @GetMapping("/expenses/filterbyCategory")
    public ResponseEntity<List<Expense>> getExpenseByCategory(@RequestParam String category){
        return new ResponseEntity<List<Expense>>(expenseService.getExpenseByCategory(category), HttpStatus.OK);
    }

    @GetMapping("/expenses/filterbyname")
    public ResponseEntity<Expense> getExpenseByKeyWord(@RequestParam String word){
        return new ResponseEntity<Expense>(expenseService.getExpenseByName(word), HttpStatus.OK);
    }

    @GetMapping("/expenses/filterByDate")
    public ResponseEntity<List<Expense>> getExpenseByDate(@RequestParam String date){
        return new ResponseEntity<List<Expense>>(expenseService.getExpenseByDate(date), HttpStatus.OK);
    }
}
