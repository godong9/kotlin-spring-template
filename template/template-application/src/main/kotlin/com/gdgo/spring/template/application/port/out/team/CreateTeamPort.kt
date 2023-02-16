package com.gdgo.spring.template.application.port.out.team

import com.gdgo.spring.template.domain.team.Team

interface CreateTeamPort {
    fun createTeam(createTeamRequest: CreateTeamRequest): Team
}

data class CreateTeamRequest(
    val name: String,
)
