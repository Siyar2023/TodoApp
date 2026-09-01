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

        // Displays the Todo title and completion status
        li.textContent = `${todo.title} - ${todo.completed ? "Completed" : "Not completed"}`;

        // Adds the Todo to the webpage
        todoList.appendChild(li);
    });
}


// Adds a new Todo
async function addTodo() {

    // Gets the title from the input field
    const titleInput = document.getElementById("title");

    // Gets the text entered by the user
    const title = titleInput.value;

    // Sends a POST request to create a new Todo
    await fetch("/todos", {

        // HTTP method used to create a new Todo
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
    loadTodos();
}


// Loads the Todos when the page is opened
loadTodos();