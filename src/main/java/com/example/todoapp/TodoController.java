package com.example.todoapp;
// Defines the package where this controller belongs.
// The package name follows the project structure.


import org.springframework.web.bind.annotation.PutMapping;
// Imports @PutMapping.
// It is used to create an HTTP PUT endpoint.
// PUT is normally used to update existing data.


import org.springframework.web.bind.annotation.PathVariable;
// Imports @PathVariable.
// It is used to read a value from the URL,
// such as the Todo ID in /todos/{id}.


import org.springframework.web.bind.annotation.GetMapping;
// Imports @GetMapping.
// @GetMapping is used to create HTTP GET endpoints.
// GET is normally used to retrieve data.


import org.springframework.web.bind.annotation.PostMapping;
// Imports @PostMapping.
// @PostMapping is used to create HTTP POST endpoints.
// POST is normally used to create new data.


import org.springframework.web.bind.annotation.RequestBody;
// Imports @RequestBody.
// @RequestBody reads data sent in the HTTP request body.
// It allows Spring to convert JSON data into a Java object.


import org.springframework.web.bind.annotation.RestController;
// Imports @RestController.
// @RestController tells Spring that this class handles REST API requests.
// The methods in this class can return data directly to the client.

import org.springframework.web.bind.annotation.DeleteMapping;
// Imports @DeleteMapping.
// It is used to create an HTTP DELETE endpoint.
// DELETE is normally used to remove existing data.


import java.util.List;
// Imports List from Java.
// List is used to store multiple Todo objects.


@RestController
// Marks this class as a REST controller.
// Spring automatically detects this class and registers its endpoints.

public class TodoController {

    private final TodoRepository todoRepository;
    // Creates a reference to TodoRepository.
    // The controller uses the repository to communicate with the database.


    public TodoController(TodoRepository todoRepository) {
        // Constructor used by Spring to provide the TodoRepository.
        // Spring automatically injects the repository into this controller.


        this.todoRepository = todoRepository;
        // Stores the TodoRepository in this controller.
        // We can now use it to access the database.
    }


    @GetMapping("/todos")
    // Creates a GET endpoint:
    // http://localhost:8080/todos
    //
    // When a GET request is sent to /todos,
    // Spring calls the getTodos() method.


    public List<Todo> getTodos() {
        // Defines the getTodos() method.
        // The method returns a List containing Todo objects.


        return todoRepository.findAll();
        // Calls findAll() from JpaRepository.
        // It retrieves all Todo objects from the database.
        //
        // The Todo objects are then returned to the client.
    }


    @PostMapping("/todos")
    // Creates a POST endpoint:
    // http://localhost:8080/todos
    //
    // POST is used to create a new Todo.


    public Todo createTodo(@RequestBody Todo todo) {
        // Defines the createTodo() method.
        //
        // @RequestBody receives JSON data from the client.
        // Spring converts the JSON data into a Todo object.
        //
        // Example JSON:
        // {
        //     "title": "Learn Spring Boot",
        //     "completed": false
        // }


        return todoRepository.save(todo);
        // Saves the Todo object to the database.
        //
        // The save() method is provided by JpaRepository.
        // The saved Todo object is returned to the client.
    }


    @PutMapping("/todos/{id}")
    // Creates a PUT endpoint:
    // http://localhost:8080/todos/1
    //
    // PUT is used to update an existing Todo.


    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo updatedTodo) {
        // Defines the updateTodo() method.
        //
        // @PathVariable gets the Todo ID from the URL.
        // @RequestBody receives the new Todo data from the request body.


        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
// Finds the Todo with the specified ID in the database.
// If the Todo exists, it is returned.
// If the Todo does not exist, TodoNotFoundException is thrown.


        todo.setTitle(updatedTodo.getTitle());
        // Updates the title of the existing Todo.


        todo.setCompleted(updatedTodo.isCompleted());
        // Updates the completed status of the existing Todo.



        return todoRepository.save(todo);
        // Saves the updated Todo in the database.
        // Returns the updated Todo to the client.


    }
    @DeleteMapping("/todos/{id}")
    // Creates a DELETE endpoint:
    // http://localhost:8080/todos/1
    //
    // DELETE is used to remove an existing Todo.


    public void deleteTodo(@PathVariable Long id) {
        // Defines the deleteTodo() method.
        //
        // @PathVariable gets the Todo ID from the URL.


        todoRepository.deleteById(id);
        // Deletes the Todo with the specified ID from the database.
    }
}