package com.gdgo.spring.template.application.service

import com.gdgo.spring.template.application.port.`in`.team.CreateTeamCommand
import com.gdgo.spring.template.application.port.`in`.team.CreateTeamResult
import com.gdgo.spring.template.application.port.`in`.team.CreateTeamUseCase
import com.gdgo.spring.template.application.port.out.team.CreateTeamPort
import com.gdgo.spring.template.application.port.out.team.CreateTeamRequest
import org.springframework.stereotype.Service

@Service
class CreateTeamService(
    private val createTeamPort: CreateTeamPort
) : CreateTeamUseCase {
    override fun createTeam(command: CreateTeamCommand): CreateTeamResult {
        val team = createTeamPort.createTeam(CreateTeamRequest(command.name))
        return CreateTeamResult(
            team.id,
            team.name,
        )
    }
}
