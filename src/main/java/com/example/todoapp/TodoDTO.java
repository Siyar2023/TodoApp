package com.example.todoapp;
// Defines the package where TodoDTO belongs.


public class TodoDTO {
    // DTO stands for Data Transfer Object.
    // This class is used to transfer Todo data
    // between the backend and the frontend.

    private Long id;
// Stores the unique ID of the Todo.
// The ID is used to identify a specific Todo.


    private String title;
    // Stores the title of the Todo.



    private boolean completed;
    // Stores whether the Todo is completed or not.
    // true = completed
    // false = not completed.


    public Long getId() {
        // Getter for the ID.
        // Allows other classes to read the Todo ID.

        return id;
        // Returns the current Todo ID.
    }


    public void setId(Long id) {
        // Setter for the ID.
        // Allows other classes to set the Todo ID.

        this.id = id;
        // Stores the provided ID in the id variable.
    }

    public String getTitle() {
        // Getter for the title.
        // Allows other classes to read the title.

        return title;
        // Returns the current title.
    }


    public void setTitle(String title) {
        // Setter for the title.
        // Allows other classes to change the title.

        this.title = title;
        // Stores the provided title in the title variable.
    }


    public boolean isCompleted() {
        // Getter for the completed status.
        // For boolean values, Java normally uses "is" instead of "get".

        return completed;
        // Returns true or false depending on the Todo status.
    }


    public void setCompleted(boolean completed) {
        // Setter for the completed status.
        // Allows other classes to change whether the Todo is completed.

        this.completed = completed;
        // Stores the provided completed value.
    }
}