package com.example.splitwise.controllers;

import com.example.splitwise.dtos.AddExpenseRequest;
import com.example.splitwise.service.ExpenseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/expense")
public class ExpenseController {

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    private final ExpenseService expenseService;



    @PostMapping(path = "/add")
    public Long addExpense(@RequestBody AddExpenseRequest request) {
        return expenseService.createExpense(request).getId();
    }

}
