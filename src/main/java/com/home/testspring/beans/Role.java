package com.home.testspring.beans;

import javax.persistence.*;

@Entity
public class Role {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    private User user;
    private String role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
