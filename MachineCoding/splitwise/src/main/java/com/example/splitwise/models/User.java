package com.example.splitwise.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

import java.util.Objects;

@Entity(name = "splitwise_user")
@Data
public class User extends BaseModel {
    private String name;
    @Column(unique = true)
    private String emailAddress;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(emailAddress, user.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, emailAddress);
    }
}
