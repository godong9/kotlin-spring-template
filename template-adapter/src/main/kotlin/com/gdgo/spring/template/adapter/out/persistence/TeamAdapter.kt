package com.gdgo.spring.template.adapter.out.persistence

import com.gdgo.spring.template.application.port.out.team.CreateTeamPort
import com.gdgo.spring.template.domain.team.Team
import org.springframework.stereotype.Service

@Service
class TeamAdapter() : CreateTeamPort {
    override fun createTeam(name: String): Team {
        TODO("Not yet implemented")
    }
}
