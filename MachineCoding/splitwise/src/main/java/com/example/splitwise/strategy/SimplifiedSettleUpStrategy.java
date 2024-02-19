package com.example.splitwise.strategy;

import com.example.splitwise.models.Expense;
import com.example.splitwise.models.ExpenseUser;
import com.example.splitwise.models.User;

import java.util.*;

public class SimplifiedSettleUpStrategy {

    public static List<Expense> settleUp(List<Expense> expenses) {
        // 1. Find all the users who paid, and are owed from the expenses.
        // 2. Divide the users in 2 groups - heaps. +ve in 1, -ve in 2.
        // 3. Pop out topmost elements from both the heaps. And create an expense.
        // 4. Insert back the left out one.
        // Keep doing this until the heap is empty.

        Map<User, Double> totalPaidOrOwed = new HashMap<>();

        // Calculate the net amount to be paid, or get back.
        for (Expense expense: expenses) {
            for (ExpenseUser expenseUser: expense.getPaidBy()) {
                totalPaidOrOwed.put(expenseUser.getUser(),
                        totalPaidOrOwed.getOrDefault(expenseUser.getUser(),
                                0.0) +  expenseUser.getAmount());
            }

            for (ExpenseUser expenseUser: expense.getOwedBy()) {
                totalPaidOrOwed.put(expenseUser.getUser(),
                        totalPaidOrOwed.getOrDefault(expenseUser.getUser(),
                                0.0) -  expenseUser.getAmount());
            }
        }

        // A: 1000
        // B: -500
        // C: -500

        PriorityQueue<ExpenseUser> paidBy = new PriorityQueue<>(new PqComparator());
        PriorityQueue<ExpenseUser> owedBy = new PriorityQueue<>(new PqComparator());

        for (Map.Entry<User, Double> userDoubleEntry : totalPaidOrOwed.entrySet()) {
            if (userDoubleEntry.getValue() >= 0) {
                paidBy.add(new ExpenseUser(userDoubleEntry.getKey(), userDoubleEntry.getValue()));
            } else {
                owedBy.add(new ExpenseUser(userDoubleEntry.getKey(), -1 * userDoubleEntry.getValue()));
            }
        }

        List<Expense> expenseList = new ArrayList<>();

        while (!paidBy.isEmpty()) {
            ExpenseUser paidByUser = paidBy.poll();
            ExpenseUser owedByUser = owedBy.poll();

            if (paidByUser.getAmount() > owedByUser.getAmount()) {
                expenseList.add(Expense.builder()
                        .owedBy(List.of(new ExpenseUser(paidByUser.getUser(), owedByUser.getAmount())))
                        .paidBy(List.of(owedByUser))
                        .build());
                paidBy.add(new ExpenseUser(paidByUser.getUser(), paidByUser.getAmount() - owedByUser.getAmount()));
            } else {
                expenseList.add(Expense.builder()
                        .owedBy(List.of(paidByUser))
                        .paidBy(List.of(new ExpenseUser(owedByUser.getUser(), paidByUser.getAmount())))
                        .build());
                owedBy.add(new ExpenseUser(owedByUser.getUser(), owedByUser.getAmount() - paidByUser.getAmount()));
            }
        }

        return expenseList;


    }


    static class PqComparator implements Comparator<ExpenseUser> {

        @Override
        public int compare(ExpenseUser u1, ExpenseUser u2) {
            if (u1.getAmount() != u2.getAmount()) {
                if (u1.getAmount() < u2.getAmount()) {
                    return 1;
                } else {
                    return -1;
                }
            }

            return 1;
        }
    }

}