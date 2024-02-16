package com.example.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseUser extends BaseModel{
    @ManyToOne
    private User user;
    private Double amount;
}
