package com.home.testspring.beans;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique=true)
    private String name;
    private String password;
    private Timestamp created;
    private Timestamp lastLogin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    @PrePersist
    protected void onCreate() {
        created = new Timestamp(System.currentTimeMillis());
    }
}
