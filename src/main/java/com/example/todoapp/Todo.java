package com.example.todoapp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Represents a Todo item in the application.
@Entity
public class Todo {

    // Unique ID for the Todo.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // The title or description of the Todo.
    private String title;

    // Shows whether the Todo is completed.
    private boolean completed;


    // Returns the Todo ID.
    public Long getId() {
        return id;
    }

    // Sets the Todo ID.
    public void setId(Long id) {
        this.id = id;
    }


    // Returns the Todo title.
    public String getTitle() {
        return title;
    }

    // Sets the Todo title.
    public void setTitle(String title) {
        this.title = title;
    }


    // Returns whether the Todo is completed.
    public boolean isCompleted() {
        return completed;
    }

    // Sets the completed status.
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}