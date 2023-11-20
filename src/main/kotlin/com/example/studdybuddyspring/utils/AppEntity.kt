package com.example.studdybuddyspring.utils

import jakarta.persistence.*
import java.util.*


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract class AppEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    open val id: UUID? = null
}
