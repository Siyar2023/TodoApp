package com.example.todoapp;

// Defines that this class belongs to the same package as TodoController
// and TodoNotFoundException.

import org.springframework.http.HttpStatus;
// Imports HTTP status codes.
// We will use NOT_FOUND (404).

import org.springframework.web.bind.annotation.ExceptionHandler;
// Used to specify which method should handle a specific exception.

import org.springframework.web.bind.annotation.ResponseStatus;
// Used to specify which HTTP status should be returned.

import org.springframework.web.bind.annotation.RestControllerAdvice;
// Makes this class a global exception handler for our REST API endpoints.


@RestControllerAdvice
// Allows this class to catch and handle exceptions
// that occur in our controllers.

public class TodoExceptionHandler {

    @ExceptionHandler(TodoNotFoundException.class)
    // Specifies that the method below should be executed
    // when a TodoNotFoundException occurs.

    @ResponseStatus(HttpStatus.NOT_FOUND)
    // Returns HTTP status 404 Not Found
    // instead of an internal server error 500.

    public String handleTodoNotFound(TodoNotFoundException exception) {
        // Receives the exception that occurred.

        return exception.getMessage();
        // Returns the error message to the client.
    }
}