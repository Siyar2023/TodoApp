package com.example.todoapp;
// Defines the package where this exception belongs.
// The package name follows the project structure.


public class TodoNotFoundException extends RuntimeException {
    // Creates a custom exception called TodoNotFoundException.
    //
    // This exception is used when a Todo with a specific ID
    // cannot be found in the database.
    //
    // RuntimeException means that this is an exception
    // that can occur while the program is running.


    public TodoNotFoundException(Long id) {
        // Constructor for the exception.
        //
        // The Todo ID is passed into the constructor
        // so that we can include it in the error message.


        super("Todo with id " + id + " not found");
        // Calls the constructor of RuntimeException.
        //
        // Creates an error message such as:
        // "Todo with id 5 not found"
        //
        // This makes it easier to understand which Todo
        // could not be found.
    }
}