package com.andrew.expensemanagerapp.service;


import com.andrew.expensemanagerapp.exception.ResourceNotFoundException;
import com.andrew.expensemanagerapp.request.ExpenseRequest;
import com.andrew.expensemanagerapp.entity.Expense;
import com.andrew.expensemanagerapp.repository.ExpenseRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }


    public List<Expense> getAllExpenses(int pageNumber, int pageSize, String direction, String sortBy) {
        Sort sort = Sort.by(parseDirection(direction), sortBy);
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return expenseRepository.findAll(pageable).getContent();
    }

    private Sort.Direction parseDirection(String direction) {
        try {
            return Sort.Direction.fromString(direction);
        } catch (IllegalArgumentException e) {
            // Default to ASC if invalid
            return Sort.Direction.ASC;
        }
    }

    public Expense getExpense(Long id) {

        return expenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Customer with id [%s] not found".formatted(id)));
    }

    public Expense addExpense(ExpenseRequest request) {
        Expense newExpense = convertToExpense(request);
        expenseRepository.save(newExpense);
        return newExpense;
    }

    private Expense convertToExpense(ExpenseRequest request) {
        return Expense.builder()
                .name(request.name())
                .description(request.description())
                .amount(request.amount())
                .category(request.category())
                .date(request.date())
                .build();
    }

    public Expense updateExpense(Long id, ExpenseRequest request) {
       Optional<Expense> expense = expenseRepository.findById(id);
       if(expense.isPresent()) {
           Expense ex = expense.get();
           ex.setName(request.name());
           ex.setAmount(request.amount());
           ex.setCategory(request.category());
           ex.setDescription(request.description());
           ex.setDate(request.date());
           expenseRepository.save(ex);
           return ex;
       }
       throw new ResourceNotFoundException("");
    }

    public void deleteExpense(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isEmpty()){
            throw new ResourceNotFoundException("");
        }
        expenseRepository.deleteById(id);
    }

    public List<Expense> getExpenseByCategory(String category) {
        return expenseRepository.findExpensesByCategory(category);
    }

    public List<Expense> getExpenseByKeyWord(String word) {
        return expenseRepository.findExpensesByKeyWord(word);
    }

    public List<Expense> getExpenseByDate(String date) {
        return expenseRepository.findExpensesByDate(date);
    }
}
