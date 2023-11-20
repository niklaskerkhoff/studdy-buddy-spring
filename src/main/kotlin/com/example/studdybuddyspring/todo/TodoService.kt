package com.example.studdybuddyspring.todo

import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class TodoService(
    private val todoRepo: TodoRepo
) {
    fun getTodos(): List<Todo> = todoRepo.findAll()

    fun getTodosFiltered(isDone: Boolean) = todoRepo.findAllByIsDone(isDone)

    fun addTodo(todo: Todo): Todo {
        todo.prepare()
        todo.checkTodo()
        return todoRepo.save(todo)
    }

    fun updateTodo(updatedTodo: Todo): Todo {
        updatedTodo.prepare()
        updatedTodo.checkTodo()

        if (updatedTodo.id == null)
            throw ResponseStatusException(HttpStatus.BAD_REQUEST)

        return todoRepo.save(updatedTodo)
    }

    fun deleteTodo(id: UUID) {
        todoRepo.findByIdOrNull(id)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
        todoRepo.deleteById(id)
    }

    private fun Todo.checkTodo() {
        if (title.isEmpty()) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST)
        }
    }

    fun getTodo(todoId: UUID) = todoRepo.findByIdOrNull(todoId)
}
