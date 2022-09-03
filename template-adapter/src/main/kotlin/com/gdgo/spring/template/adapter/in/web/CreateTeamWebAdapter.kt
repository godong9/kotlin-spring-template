package com.gdgo.spring.template.adapter.`in`.web

import com.gdgo.spring.template.application.port.`in`.team.CreateTeamCommand
import com.gdgo.spring.template.application.port.`in`.team.CreateTeamUseCase
import com.gdgo.spring.template.domain.team.Team
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateTeamWebAdapter(
    private val createTeamUseCase: CreateTeamUseCase,
) {
    @Transactional
    fun createTeam(command: CreateTeamCommand): Team {
        return createTeamUseCase.createTeam(command)
    }
}
