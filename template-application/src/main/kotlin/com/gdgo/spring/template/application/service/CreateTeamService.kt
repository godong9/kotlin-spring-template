package com.gdgo.spring.template.application.service

import com.gdgo.spring.template.application.port.`in`.team.CreateTeamCommand
import com.gdgo.spring.template.application.port.`in`.team.CreateTeamUseCase
import com.gdgo.spring.template.application.port.out.team.CreateTeamPort
import com.gdgo.spring.template.domain.team.Team
import org.springframework.stereotype.Service

@Service
class CreateTeamService(
    private val createTeamPort: CreateTeamPort
) : CreateTeamUseCase {
    override fun createTeam(command: CreateTeamCommand): Team {
        return createTeamPort.createTeam(command.name)
    }
}
