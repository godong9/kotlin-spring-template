package com.gdgo.spring.template.adapter.config

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@EnableJpaAuditing
@EnableTransactionManagement
@EntityScan(basePackages = ["com.gdgo.spring.template.adapter.out.persistence.jpa"])
@EnableJpaRepositories(basePackages = ["com.gdgo.spring.template.adapter.out.persistence.jpa"])
class JpaConfig(
    @PersistenceContext
    private val entityManager: EntityManager,
) {
    @Bean
    fun jpaQueryFactory(): JPAQueryFactory {
        return JPAQueryFactory(entityManager)
    }
}
