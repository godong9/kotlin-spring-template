package com.gdgo.spring.template.adapter.out.persistence

import com.gdgo.spring.template.adapter.out.persistence.jpa.team.TeamJpaEntity
import com.gdgo.spring.template.adapter.out.persistence.jpa.team.TeamJpaRepository
import com.gdgo.spring.template.application.port.out.team.CreateTeamPort
import com.gdgo.spring.template.domain.team.Team
import org.springframework.stereotype.Service

@Service
class TeamAdapter(
    private val teamJpaRepository: TeamJpaRepository
) : CreateTeamPort {
    override fun createTeam(name: String): Team {
        return teamJpaRepository.save(TeamJpaEntity(name = name)).toDomainModel()
    }
}
