package com.gdgo.spring.template.adapter.out.persistence.jpa.team

interface TeamJpaRepositoryCustom {
    fun findByNameSupport(name: String): List<TeamJpaEntity>
}
