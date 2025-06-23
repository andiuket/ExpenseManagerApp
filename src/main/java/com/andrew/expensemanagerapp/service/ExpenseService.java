package com.andrew.expensemanagerapp.service;


import com.andrew.expensemanagerapp.exception.RequestValidationException;
import com.andrew.expensemanagerapp.exception.ResourceNotFoundException;
import com.andrew.expensemanagerapp.io.ExpenseRequest;
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
                        "Expense with id [%s] not found".formatted(id)));
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
           boolean changes = false;
           Expense ex = expense.get();
           if(request.name() != null && !request.name().equals(ex.getName())){
               ex.setName(request.name());
               expenseRepository.save(ex);
               changes = true;
           }
           if(request.amount() != null && !request.amount().equals(ex.getAmount())){
               ex.setAmount(request.amount());
               expenseRepository.save(ex);
               changes = true;
           }
           if(request.description() != null && !request.description().equals(ex.getDescription())){
               ex.setDescription(request.description());
               expenseRepository.save(ex);
               changes = true;
           }
           if(request.category() != null && !request.category().equals(ex.getCategory())){
               ex.setCategory(request.category());
               expenseRepository.save(ex);
               changes = true;
           }

           if(request.date() != null && !request.date().equals(ex.getDate())){
               ex.setDate(request.date());
               expenseRepository.save(ex);
               changes = true;
           }
           if(!changes){
               throw new RequestValidationException("No data Changes found");
           }
           expenseRepository.save(ex);
           return ex;
       }
       throw new ResourceNotFoundException("Expense with id [%s] not found");
    }

    public void deleteExpense(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isEmpty()){
            throw new ResourceNotFoundException("Expense with id not found");
        }
        expenseRepository.deleteById(id);
    }

    public List<Expense> getExpenseByCategory(String category) {
        return expenseRepository.findExpensesByCategory(category);
    }

    public Expense getExpenseByName(String word) {
        return expenseRepository.findExpenseByName(word);
    }

    public List<Expense> getExpenseByDate(String date) {
        return expenseRepository.findExpensesByDate(date);
    }
}
