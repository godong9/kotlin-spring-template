package com.gdgo.spring.template.adapter.out.persistence.jpa.team

import com.gdgo.spring.template.adapter.out.persistence.jpa.team.QTeamJpaEntity.teamJpaEntity
import com.querydsl.jpa.impl.JPAQueryFactory

class TeamJpaRepositoryCustomImpl(
    private val jpaQueryFactory: JPAQueryFactory
) : TeamJpaRepositoryCustom {

    override fun findByNameSupport(name: String): List<TeamJpaEntity> {
        return jpaQueryFactory.selectFrom(teamJpaEntity)
            .where(teamJpaEntity.name.eq(name))
            .fetch()
    }
}
