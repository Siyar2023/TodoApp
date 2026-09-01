console.log("Todo App frontend is working!");

// Loads all Todos from the backend
async function loadTodos() {

    // Sends a GET request to the /todos endpoint
    const response = await fetch("/todos");

    // Converts the response from JSON into JavaScript data
    const todos = await response.json();

    // Prints the received Todos in the browser console
    console.log("Todos received:", todos);

    // Finds the Todo list in the HTML
    const todoList = document.getElementById("todoList");

    // Clears the existing list
    todoList.innerHTML = "";

    // Loops through all Todos
    todos.forEach(todo => {

        // Creates a new list item
        const li = document.createElement("li");

        // Creates a text element for the Todo
        const text = document.createElement("span");

        // Displays the Todo title and completion status
        text.textContent = `${todo.title} - ${todo.completed ? "Completed" : "Not completed"}`;

        // Creates a Complete button
        const completeButton = document.createElement("button");

        // Sets the button text
        completeButton.textContent = todo.completed ? "Undo" : "Complete";

        // Adds a click event to the Complete button
        completeButton.onclick = async () => {
            await toggleTodo(todo);
        };

        // Creates a Delete button
        const deleteButton = document.createElement("button");

        // Sets the button text
        deleteButton.textContent = "Delete";

        // Adds a click event to the Delete button
        deleteButton.onclick = async () => {
            await deleteTodo(todo.id);
        };

        // Adds the Todo text to the list item
        li.appendChild(text);

        // Adds the Complete button to the Todo
        li.appendChild(completeButton);

        // Adds the Delete button to the Todo
        li.appendChild(deleteButton);

        // Adds the Todo to the webpage
        todoList.appendChild(li);
    });
}


// Adds a new Todo
async function addTodo() {

    // Gets the input field
    const titleInput = document.getElementById("title");

    // Gets the text entered by the user
    const title = titleInput.value;

    // Sends a POST request to create a new Todo
    await fetch("/todos", {
        method: "POST",

        // Tells the backend that we are sending JSON
        headers: {
            "Content-Type": "application/json"
        },

        // Sends the Todo data as JSON
        body: JSON.stringify({
            title: title,
            completed: false
        })
    });

    // Clears the input field
    titleInput.value = "";

    // Reloads the Todo list
    await loadTodos();
}


// Toggles a Todo between completed and not completed
async function toggleTodo(todo) {

    // Sends a PUT request to update the Todo
    await fetch(`/todos/${todo.id}`, {
        method: "PUT",

        // Tells the backend that we are sending JSON
        headers: {
            "Content-Type": "application/json"
        },

        // Sends the updated Todo data
        body: JSON.stringify({
            title: todo.title,
            completed: !todo.completed
        })
    });

    // Reloads the Todo list
    await loadTodos();
}


// Deletes a Todo from the backend
async function deleteTodo(id) {

    // Sends a DELETE request to the backend
    await fetch(`/todos/${id}`, {
        method: "DELETE"
    });

    // Reloads the Todo list
    await loadTodos();
}


/// Loads the Todos when the page is opened
(async function () {
    await loadTodos();
})();
