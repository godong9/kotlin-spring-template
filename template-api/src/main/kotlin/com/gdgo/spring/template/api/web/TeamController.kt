package com.gdgo.spring.template.api.web

import com.fasterxml.jackson.annotation.JsonProperty
import com.gdgo.spring.template.adapter.`in`.web.CreateTeamWebAdapter
import com.gdgo.spring.template.application.port.`in`.team.CreateTeamCommand
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.constraints.NotNull

@ApiV1Controller
class TeamController(
    private val createTeamWebAdapter: CreateTeamWebAdapter,
) {
    @Operation(summary = "Create Team")
    @PostMapping("/teams")
    fun createTeam(@RequestBody createTeamRequest: CreateTeamRequest): CreateTeamResponse {
        val team = createTeamWebAdapter.createTeam(CreateTeamCommand(name = createTeamRequest.teamName))
        return CreateTeamResponse(id = team.id)
    }

    data class CreateTeamRequest(
        @Schema(description = "Team name")
        @JsonProperty("team_name")
        @field:NotNull
        val teamName: String,
    )

    data class CreateTeamResponse(
        @Schema(description = "Team id", name = "id")
        val id: Long,
    )
}
