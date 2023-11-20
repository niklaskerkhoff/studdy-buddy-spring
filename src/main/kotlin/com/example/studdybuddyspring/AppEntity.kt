package com.example.studdybuddyspring

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import java.util.*


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract class AppEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    open val id: UUID? = null
}
