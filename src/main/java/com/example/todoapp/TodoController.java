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
// It is used to create HTTP GET endpoints.
// GET is normally used to retrieve data.


import org.springframework.web.bind.annotation.PostMapping;
// Imports @PostMapping.
// It is used to create HTTP POST endpoints.
// POST is normally used to create new data.


import org.springframework.web.bind.annotation.RequestBody;
// Imports @RequestBody.
// It reads data sent in the HTTP request body.
// Spring converts the JSON data into a Java object.


import org.springframework.web.bind.annotation.RestController;
// Imports @RestController.
// It tells Spring that this class handles REST API requests.
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

    private final TodoService todoService;
    // Creates a reference to TodoService.
    // The Controller uses the Service Layer to handle application logic.


    private final TodoRepository todoRepository;
    // Creates a reference to TodoRepository.
    // POST, PUT and DELETE still use the Repository directly for now.
    // These operations will be moved to TodoService in later steps.


    public TodoController(
            TodoService todoService,
            TodoRepository todoRepository) {
        // Constructor used by Spring to provide TodoService
        // and TodoRepository automatically.

        this.todoService = todoService;
        // Stores TodoService so the Controller can use it.


        this.todoRepository = todoRepository;
        // Stores TodoRepository so the Controller can use it
        // for the operations that have not yet been moved to the Service Layer.
    }


    @GetMapping("/todos")
    // Creates a GET endpoint:
    // http://localhost:8080/todos
    //
    // When a GET request is sent to /todos,
    // Spring calls the getTodos() method.


    public List<TodoDTO> getTodos() {
        // Returns a list of TodoDTO objects to the frontend.

        return todoService.getAllTodos();
        // Calls the Service Layer to retrieve the Todos as DTOs.
    }


    @PostMapping("/todos")
    // Creates a POST endpoint:
    // http://localhost:8080/todos
    // POST is used to create a new Todo.


    public Todo createTodo(@RequestBody TodoDTO todoDTO) {
        // Receives Todo data from the frontend through TodoDTO.

        return todoService.createTodo(todoDTO);
        // Sends the DTO to the Service Layer.
    }


    @PutMapping("/todos/{id}")
    // Creates a PUT endpoint:
    // http://localhost:8080/todos/1
    //
    // PUT is used to update an existing Todo.


    public Todo updateTodo(
            @PathVariable Long id,
            @RequestBody TodoDTO todoDTO) {
        // Gets the Todo ID from the URL.
        // Receives the updated Todo data through TodoDTO.

        return todoService.updateTodo(id, todoDTO);
        // Sends the DTO to the Service Layer.
        // The Service updates the Todo entity.
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


        todoService.deleteTodo(id);
// Calls the Service Layer to delete the Todo.
// The Service communicates with the Repository.
    }
}