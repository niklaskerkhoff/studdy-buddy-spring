package com.example.studdybuddyspring.todo

import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("todos")
class TodoController(
    private val todoService: TodoService
) {
    @GetMapping
    fun getTodos() = todoService.getTodos()

    @GetMapping("{todoId}")
    fun getTodo(@PathVariable todoId: UUID) = todoService.getTodo(todoId)

    @PostMapping
    fun addTodo(@RequestBody todo: Todo) = todoService.addTodo(todo)

    @PutMapping
    fun updateTodo(@RequestBody todo: Todo) = todoService.updateTodo(todo)

    @DeleteMapping("{todoId}")
    fun deleteTodo(@PathVariable todoId: UUID) = todoService.deleteTodo(todoId)
}
