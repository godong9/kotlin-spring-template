package com.gdgo.spring.template.adapter.out.persistence.jpa.team

import org.springframework.data.jpa.repository.JpaRepository

interface TeamJpaRepository : JpaRepository<TeamJpaEntity, Long>, TeamJpaRepositoryCustom
