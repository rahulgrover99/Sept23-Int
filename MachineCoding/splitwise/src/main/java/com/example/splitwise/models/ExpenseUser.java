package com.example.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class ExpenseUser extends BaseModel{
    @ManyToOne
    private User user;
    private Double amount;
}
