package com.example.studdybuddyspring.todo

import java.util.UUID

class Todo(
    var title: String,
    var description: String,
    var isDone: Boolean = false,
    var id: UUID? = null
) {
    fun prepare() {
        title = title.trim()
    }
}
