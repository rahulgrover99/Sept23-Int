package com.example.splitwise.service;

import com.example.splitwise.dtos.AddExpenseRequest;
import com.example.splitwise.models.Expense;
import com.example.splitwise.models.ExpenseUser;
import com.example.splitwise.models.User;
import com.example.splitwise.repository.ExpenseRepository;
import com.example.splitwise.repository.ExpenseUserRepository;
import com.example.splitwise.repository.GroupRepository;
import com.example.splitwise.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ExpenseService {

    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final ExpenseRepository expenseRepository;
    private final ExpenseUserRepository expenseUserRepository;

    public ExpenseService(UserRepository userRepository, GroupRepository groupRepository, ExpenseRepository expenseRepository, ExpenseUserRepository expenseUserRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.expenseRepository = expenseRepository;
        this.expenseUserRepository = expenseUserRepository;
    }

    public Expense createExpense(AddExpenseRequest request) {

        // Step 1: Create expense users.

        Map<Long, Double> paidBy = request.getPaidBy();
        List<ExpenseUser> paidByExpenseUsers = new ArrayList<>();


        paidBy.forEach((userId, amount) -> {
            User user = userRepository.findById(userId).get();
            ExpenseUser expenseUser= expenseUserRepository.save(new ExpenseUser(user, amount));
            paidByExpenseUsers.add(expenseUser);
        });

        Map<Long, Double> owedBy = request.getOwedBy();
        List<ExpenseUser> owedByExpenseUsers = new ArrayList<>();


        owedBy.forEach((userId, amount) -> {
            User user = userRepository.findById(userId).get();
            ExpenseUser expenseUser = expenseUserRepository.save(new ExpenseUser(user, amount));
            owedByExpenseUsers.add(expenseUser);
        });


        Expense expense = Expense.builder().name(request.getName())
                .type(request.getExpenseType()).paidBy(paidByExpenseUsers)
                .owedBy(owedByExpenseUsers).totalAmount(request.getTotalAmount()).build();

        return expenseRepository.save(expense);

    }

}
