package com.example.studdybuddyspring.todo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface TodoRepo : JpaRepository<Todo, UUID>
