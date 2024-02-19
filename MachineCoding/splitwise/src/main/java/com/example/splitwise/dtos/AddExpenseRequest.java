package com.example.splitwise.dtos;

import com.example.splitwise.models.ExpenseType;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class AddExpenseRequest {
    private String name;
    private ExpenseType expenseType;
    private Double totalAmount;
    private Map<Long, Double> paidBy;
    private Map<Long, Double> owedBy;
    private String groupName;
}
