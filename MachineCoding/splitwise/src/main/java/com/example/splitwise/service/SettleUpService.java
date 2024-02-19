package com.example.splitwise.service;

import com.example.splitwise.models.Expense;
import com.example.splitwise.models.ExpenseUser;
import com.example.splitwise.models.Group;
import com.example.splitwise.models.User;
import com.example.splitwise.repository.ExpenseRepository;
import com.example.splitwise.repository.ExpenseUserRepository;
import com.example.splitwise.repository.GroupRepository;
import com.example.splitwise.repository.UserRepository;
import com.example.splitwise.strategy.SimplifiedSettleUpStrategy;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SettleUpService {

    private final GroupRepository groupRepository;
    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    public SettleUpService(GroupRepository groupRepository, ExpenseRepository expenseRepository, UserRepository userRepository, ExpenseUserRepository expenseUserRepository) {
        this.groupRepository = groupRepository;
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
        this.expenseUserRepository = expenseUserRepository;
    }

    private final ExpenseUserRepository expenseUserRepository;




    // A <- 1000
    // B -> 2000
    // C -< 600
    // D <- 400

    // B -> A 1000
    // B -> C 600
    // B -> D 400

    public List<Expense> settleUpGroup(Long groupId) {
        // 1. Fetch the group by group Id.

        Optional<Group> groupToSettle = groupRepository.findById(groupId);


        return SimplifiedSettleUpStrategy
                .settleUp(groupToSettle.get().getExpenses());


    }


    public List<Expense> settleUpUserInGroup(Long groupId, Long userId) {
        List<Expense> settlingUpAGroup = settleUpGroup(groupId);
        List<Expense> result = new ArrayList<>();
        User user = userRepository.findById(userId).get();
        for (Expense expense: settlingUpAGroup) {
            if (expense.getOwedBy().stream()
                    .anyMatch(expenseUser -> expenseUser.getUser().equals(user)) ||
                    expense.getPaidBy().stream()
                    .anyMatch(expenseUser -> expenseUser.getUser().equals(user))) {
                result.add(expense);
            }
        }
        return result;
    }

    public List<Expense> settleUpUser(Long userId) {
        User user = userRepository.findById(userId).get();

        List<ExpenseUser> expenseUsers = expenseUserRepository.getAllByUser(user);

        List<Expense> expenses = expenseRepository.findAllByPaidByInOrOwedByIn(expenseUsers, expenseUsers);

        return SimplifiedSettleUpStrategy.settleUp(expenses);
    }


}



// ABC -> 1200
// All owed 400

// XYZ -> 2000
// ABC <- 1000
// XYZ <- 500
// MNO <- 500

//ABC -> 1200 - 400 - 1000
//ABC -> 200

// XYZ -400 -500 + 2000
// XYZ <- 1100

// MNO -> 900

