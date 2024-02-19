package com.example.splitwise.controllers;

import com.example.splitwise.models.Expense;
import com.example.splitwise.service.SettleUpService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/settleUp")
public class SettleUpController {


    private final SettleUpService settleUpService;

    public SettleUpController(SettleUpService settleUpService) {
        this.settleUpService = settleUpService;
    }

    @GetMapping("/group/{groupId}")
    public List<Expense> settleUpGroup(
            @PathVariable(name = "groupId") Long groupId) {
       return settleUpService.settleUpGroup(groupId);

    }

    @GetMapping("/group/{groupId}/user/{userId}")
    public List<Expense> settleUpGroupForUser(
            @PathVariable(name = "groupId") Long groupId,
            @PathVariable(name = "userId") Long userId) {
        return settleUpService.settleUpUserInGroup(groupId, userId);

    }

    @GetMapping("/user/{userId}")
    public List<Expense> settleUpGroupForUser(
            @PathVariable(name = "userId") Long userId) {
        return settleUpService.settleUpUser(userId);

    }


}
