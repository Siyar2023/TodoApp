package com.example.todoapp;
// Defines the package where this interface belongs.
// It is located in the main application package.


// Imports JpaRepository from Spring Data JPA.
// JpaRepository provides ready-made methods for working with the database.
import org.springframework.data.jpa.repository.JpaRepository;


// Defines the TodoRepository interface.
// The interface is used to communicate with the database
// and perform database operations for Todo objects.
public interface TodoRepository extends JpaRepository<Todo, Long> {


    // No methods need to be written here.
    //
    // By extending JpaRepository, Spring automatically provides
    // common database operations such as:
    //
    // save()       -> Saves a Todo to the database.
    // findAll()    -> Retrieves all Todos.
    // findById()   -> Finds a Todo by its ID.
    // deleteById() -> Deletes a Todo by its ID.
}