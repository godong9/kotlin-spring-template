package com.gdgo.spring.template.application.port.`in`.team

import com.gdgo.spring.template.domain.team.Team

interface CreateTeamUseCase {
    fun createTeam(command: CreateTeamCommand): Team
}
