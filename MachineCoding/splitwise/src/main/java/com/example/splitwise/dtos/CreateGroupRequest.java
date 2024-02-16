package com.example.splitwise.dtos;

import lombok.Data;

import java.util.List;

@Data
public class CreateGroupRequest {
    private String name;
    private boolean enableSimplifyDebt;
    private List<Long> userIds;
}
