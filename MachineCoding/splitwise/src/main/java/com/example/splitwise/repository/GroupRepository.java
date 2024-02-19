package com.example.splitwise.repository;

import com.example.splitwise.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long> {


    Optional<Group> findByName(String name);
}
