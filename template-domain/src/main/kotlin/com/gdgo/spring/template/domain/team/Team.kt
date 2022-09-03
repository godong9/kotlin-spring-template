package com.gdgo.spring.template.domain.team

import com.gdgo.spring.template.domain.member.Member

class Team(
    val id: Long,
    val name: String,
    val members: List<Member>,
)
