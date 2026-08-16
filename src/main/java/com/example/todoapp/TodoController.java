package com.example.todoapp;
// Defines the package where this Java class belongs.
// The package name usually follows the project structure.


import org.springframework.web.bind.annotation.GetMapping;
// Imports @GetMapping.
// @GetMapping is used to handle HTTP GET requests.


import org.springframework.web.bind.annotation.RestController;
// Imports @RestController.
// This tells Spring that this class is a REST controller
// and can handle HTTP requests.


@RestController
// Marks this class as a REST controller.
// Spring Boot will detect this class automatically
// and use it to handle API requests.


public class TodoController {
// Defines the TodoController class.
// This class contains the REST API endpoints for our Todo app.


    @GetMapping("/hello")
    // Creates a GET endpoint at:
    // http://localhost:8080/hello
    //
    // When a user visits /hello,
    // Spring Boot calls the hello() method.


    public String hello() {
        // Defines the hello() method.
        // The method returns a String response.


        return "Hello from Todo App!";
        // Sends this text back to the browser
        // as the response from the /hello endpoint.
    }


    @GetMapping("/todos")
    // Creates another GET endpoint at:
    // http://localhost:8080/todos
    //
    // When a user visits /todos,
    // Spring Boot calls the todos() method.


    public String todos() {
        // Defines the todos() method.
        // The method returns the Todo list as a String.


        return """
            1. Learn Java <br>
            2. Learn Spring Boot <br>
            3. Build REST API
            """;
        // Returns a text block containing three Todo items.
        //
        // <br> is an HTML line break.
        // It makes each Todo item appear on a separate line
        // when displayed by the browser.
    }
}