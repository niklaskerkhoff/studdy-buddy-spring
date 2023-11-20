package com.example.studdybuddyspring.todo

import com.example.studdybuddyspring.utils.findIndexOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.UUID

@Service
class TodoService {

    private val todos = mutableListOf<Todo>(
        Todo("adsfas", "asdhgsdghdsfg", false, UUID.randomUUID()),
        Todo("a", "f", true, UUID.randomUUID()),
        Todo("df", "fs", false, UUID.randomUUID()),
    )

    fun getTodos(): List<Todo> {
        return todos
    }

    fun addTodo(todo: Todo): Todo {
        todo.prepare()
        todo.checkTodo()
        todo.id = UUID.randomUUID()
        todos.add(todo)

        return todo
    }

    fun updateTodo(todo: Todo): Todo {
        todo.prepare()
        todo.checkTodo()

        val index = todos.findIndexOrNull { it.id == todo.id }
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

        todos[index] = todo

        return todo
    }

    fun deleteTodo(id: UUID) {
        val prevSize = todos.size
        todos.removeIf { it.id == id }

        if (todos.size == prevSize) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
        }
    }

    private fun Todo.checkTodo() {
        if (title.isEmpty()) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST)
        }
    }

    fun getTodo(todoId: UUID) = todos.find { it.id == todoId }
        ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
}
