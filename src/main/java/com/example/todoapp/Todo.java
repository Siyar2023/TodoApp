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
}