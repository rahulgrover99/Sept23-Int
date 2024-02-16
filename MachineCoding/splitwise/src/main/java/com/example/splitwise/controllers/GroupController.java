package com.example.splitwise.controllers;

import com.example.splitwise.dtos.CreateGroupRequest;
import com.example.splitwise.models.Group;
import com.example.splitwise.repository.GroupRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/group")
public class GroupController {

    // Add a post mapping for
    // creating a group.
    @PostMapping(path = "/create")
    public Long createGroup(@RequestBody CreateGroupRequest request) {
        return 1L;
    }

}
