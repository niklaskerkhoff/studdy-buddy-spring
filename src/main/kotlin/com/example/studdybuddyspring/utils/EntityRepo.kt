package com.example.studdybuddyspring.utils

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean
import java.util.*

@NoRepositoryBean
interface EntityRepo<E> : JpaRepository<E, UUID>
