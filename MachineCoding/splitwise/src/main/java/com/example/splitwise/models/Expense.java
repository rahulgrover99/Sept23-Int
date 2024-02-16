package com.example.splitwise.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Map;

@Entity
public class Expense extends BaseModel {
    private String name;
    @Enumerated(EnumType.STRING)
    private ExpenseType type;
    private double totalAmount;


    // who all paid in this expense.
    @ManyToOne
    private Group group;

    @OneToMany
    private List<ExpenseUser> paidBy;
    @OneToMany
    private List<ExpenseUser> owedBy;
    // who all owe some amount in the expense.
}
