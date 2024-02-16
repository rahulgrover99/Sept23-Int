package com.example.splitwise.repository;

import com.example.splitwise.models.ExpenseUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseUserRepository extends JpaRepository<ExpenseUser, Long> {
}
