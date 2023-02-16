package com.gdgo.spring.template.application.port.`in`.team

interface CreateTeamUseCase {
    fun createTeam(command: CreateTeamCommand): CreateTeamResult
}

data class CreateTeamCommand(
    val name: String,
)

data class CreateTeamResult(
    val id: Long,
    val name: String,
)
