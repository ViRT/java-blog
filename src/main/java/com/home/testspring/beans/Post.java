package com.home.testspring.beans;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(columnDefinition = "text")
    @NotEmpty(message = "Please enter message body.")
    private String body;
    @ManyToOne
    private User author;
    private Timestamp created;
    private Timestamp modified;
    private Boolean active;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getModified() {
        return modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Post: id[" + getId() + "] body[" + getBody() + "] author[" + (getAuthor() == null ? "" : getAuthor().getUsername()) + "] created[" + getCreated() + "]";
    }

    @PrePersist
    protected void onCreate() {
        created = new Timestamp(System.currentTimeMillis());
        modified = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    protected void onUpdate() {
        modified = new Timestamp(System.currentTimeMillis());
    }
}
