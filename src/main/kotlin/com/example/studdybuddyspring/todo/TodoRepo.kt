package com.example.studdybuddyspring.todo

import com.example.studdybuddyspring.utils.EntityRepo
import org.springframework.stereotype.Repository

@Repository
interface TodoRepo : EntityRepo<Todo> {
    fun findAllByIsDone(done: Boolean): List<Todo>
}
