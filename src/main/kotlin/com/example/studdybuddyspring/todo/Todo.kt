package com.example.studdybuddyspring.todo

import com.example.studdybuddyspring.AppEntity
import jakarta.persistence.Entity

@Entity
class Todo(
    var title: String,
    var description: String,
    var isDone: Boolean = false,
) : AppEntity() {
    fun prepare() {
        title = title.trim()
    }
}
