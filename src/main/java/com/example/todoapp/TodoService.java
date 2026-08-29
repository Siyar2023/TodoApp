package com.example.todoapp;
// Defines the package where TodoService belongs.


import org.springframework.stereotype.Service;
// Imports @Service.
// This tells Spring that this class belongs to the Service Layer.


import java.util.List;
// Imports List.
// We use List to return multiple Todo objects.


@Service
// Marks this class as a Spring Service component.

public class TodoService {

    private final TodoRepository todoRepository;
    // Reference to TodoRepository.
    // The repository is used to communicate with the database.


    public TodoService(TodoRepository todoRepository) {
        // Constructor used by Spring to inject TodoRepository.

        this.todoRepository = todoRepository;
        // Stores the repository so it can be used by the Service.
    }

    public List<TodoDTO> getAllTodos() {
        // Retrieves all Todos from the database
        // and converts them into TodoDTO objects.

        return todoRepository.findAll()
                .stream()
                .map(todo -> {
                    // Converts each Todo entity into a TodoDTO.

                    TodoDTO dto = new TodoDTO();
                    // Creates a new TodoDTO object.

                    dto.setId(todo.getId());
// Copies the ID from the Todo entity to the TodoDTO.
// This allows the frontend to identify each Todo.

                    dto.setTitle(todo.getTitle());
                    // Copies the title from the Todo entity to the DTO.

                    dto.setCompleted(todo.isCompleted());
                    // Copies the completed status from the Todo entity to the DTO.

                    return dto;
                    // Returns the DTO for this Todo.
                })
                .toList();
        // Collects all TodoDTO objects into a List.
    }

    public Todo createTodo(TodoDTO todoDTO) {
        // Receives Todo data through a DTO.
        // The DTO contains the data received from the frontend.


        Todo todo = new Todo();
        // Creates a new Todo entity.
        // The entity will be stored in the database.


        todo.setTitle(todoDTO.getTitle());
        // Gets the title from the DTO
        // and puts it into the Todo entity.


        todo.setCompleted(todoDTO.isCompleted());
        // Gets the completed status from the DTO
        // and puts it into the Todo entity.


        return todoRepository.save(todo);
        // Saves the Todo entity to the database.
        // The saved Todo is returned.
    }
    public Todo updateTodo(Long id, TodoDTO todoDTO) {
        // Receives the updated Todo data through a DTO.
        // The DTO contains the data sent from the frontend.

        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
        // Finds the Todo with the specified ID in the database.
        // If the Todo exists, it is returned.
        // If the Todo does not exist, TodoNotFoundException is thrown.


        todo.setTitle(todoDTO.getTitle());
// Gets the title from the DTO
// and updates the Todo entity.


        todo.setCompleted(todoDTO.isCompleted());
// Gets the completed status from the DTO
// and updates the Todo entity.


        return todoRepository.save(todo);
        // Saves the updated Todo in the database.
        // Returns the updated Todo.
    }
    public void deleteTodo(Long id) {
        // Deletes an existing Todo using the Service Layer.
        // The Controller will call this method when a DELETE request is received.


        todoRepository.deleteById(id);
        // Deletes the Todo with the specified ID from the database.
    }
}