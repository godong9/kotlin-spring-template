package com.gdgo.spring.template.application.port.`in`.team

interface LoadTeamUseCase {
    fun loadAllTeam(query: LoadTeamQuery): List<LoadTeamResult>
}

data class LoadTeamQuery(
    val name: String,
)

data class LoadTeamResult(
    val id: Long,
    val name: String,
)
