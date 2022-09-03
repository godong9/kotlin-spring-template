package com.gdgo.spring.template.adapter.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@EnableJpaAuditing
@EnableTransactionManagement
@EntityScan(basePackages = ["com.gdgo.spring.template.adapter.out.persistence.jpa"])
@EnableJpaRepositories(basePackages = ["com.gdgo.spring.template..adapter.out.persistence.jpa"])
class JpaConfig
