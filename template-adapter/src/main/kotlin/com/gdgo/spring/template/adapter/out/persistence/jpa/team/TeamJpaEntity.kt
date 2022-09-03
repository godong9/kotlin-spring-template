package com.gdgo.spring.template.adapter.out.persistence.jpa.team

import com.gdgo.spring.template.adapter.out.persistence.jpa.MutableBaseEntity
import com.gdgo.spring.template.domain.team.Team
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Index
import javax.persistence.Table

@Entity
@Table(
    name = "teams",
    indexes = [
        Index(name = "idx_name", columnList = "name")
    ]
)
class TeamJpaEntity(
    @Id
    @GeneratedValue
    val id: Long = 0L,

    @Column(name = "name", nullable = false, length = 50)
    val name: String,
) : MutableBaseEntity() {
    fun toDomainModel(): Team {
        return Team(
            id = id,
            name = name,
            members = null,
        )
    }

    companion object {
        fun from(domainModel: Team): TeamJpaEntity {
            return TeamJpaEntity(
                id = domainModel.id,
                name = domainModel.name,
            )
        }
    }
}
