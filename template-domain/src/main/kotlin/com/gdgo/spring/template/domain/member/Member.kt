package com.gdgo.spring.template.domain.member

import com.gdgo.spring.template.domain.team.Team

data class Member(
    val id: Long,
    val name: String,
    val email: String,
    val team: Team,
)
