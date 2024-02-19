package com.example.splitwise.repository;

import com.example.splitwise.models.Expense;
import com.example.splitwise.models.ExpenseUser;
import com.example.splitwise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    public List<Expense> findAllByPaidByInOrOwedByIn(List<ExpenseUser> e1, List<ExpenseUser> e2);
}
