package com.example.todoapp;
// Defines the package where this test class belongs.


import org.junit.jupiter.api.Test;
// Imports @Test.
// @Test tells JUnit that a method is a test.


import org.junit.jupiter.api.extension.ExtendWith;
// Allows JUnit to use Mockito.


import org.mockito.InjectMocks;
// Creates TodoService and injects its dependencies.


import org.mockito.Mock;
// Creates a mock version of TodoRepository.


import org.mockito.junit.jupiter.MockitoExtension;
// Enables Mockito in this JUnit test.


import java.util.List;
// Imports List.
// We use List to work with multiple Todo objects.


import static org.mockito.Mockito.when;
// Imports Mockito's when() method.
// It allows us to define what the mock should return.


import static org.junit.jupiter.api.Assertions.assertTrue;
// Imports assertTrue.
// It checks whether a condition is true.

import static org.mockito.Mockito.verify;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
// Enables Mockito for this test class.


class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;
    // Creates a fake TodoRepository.
    // No real database is used.


    @InjectMocks
    private TodoService todoService;
    // Creates TodoService.
    // Mockito injects the mock TodoRepository into it.


    @Test
    void testGetAllTodosWithTodo() {

        Todo todo = new Todo();

        todo.setId(1L);
        todo.setTitle("Learn Spring Boot");
        todo.setCompleted(false);

        when(todoRepository.findAll()).thenReturn(List.of(todo));

        List<TodoDTO> todos = todoService.getAllTodos();

        assertEquals(1, todos.size());
        assertEquals(1L, todos.get(0).getId());
        assertEquals("Learn Spring Boot", todos.get(0).getTitle());
        assertEquals(false, todos.get(0).isCompleted());
    }

    @Test
    void testCreateTodo() {

        TodoDTO todoDTO = new TodoDTO();
        todoDTO.setTitle("Learn Spring Boot");
        todoDTO.setCompleted(false);

        Todo savedTodo = new Todo();
        savedTodo.setId(1L);
        savedTodo.setTitle("Learn Spring Boot");
        savedTodo.setCompleted(false);

        when(todoRepository.save(org.mockito.ArgumentMatchers.any(Todo.class)))
                .thenReturn(savedTodo);

        Todo result = todoService.createTodo(todoDTO);

        assertEquals(1L, result.getId());
        assertEquals("Learn Spring Boot", result.getTitle());
        assertEquals(false, result.isCompleted());

        verify(todoRepository).save(org.mockito.ArgumentMatchers.any(Todo.class));
    }
}