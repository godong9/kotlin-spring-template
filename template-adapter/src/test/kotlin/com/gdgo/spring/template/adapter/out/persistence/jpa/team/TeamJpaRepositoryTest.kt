package com.gdgo.spring.template.adapter.out.persistence.jpa.team

import com.gdgo.spring.template.adapter.config.JpaConfig
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ContextConfiguration

@DataJpaTest
@ContextConfiguration(classes = [JpaConfig::class])
class TeamJpaRepositoryTest {
    @Autowired
    private lateinit var sut: TeamJpaRepository

    @DisplayName("[save] 팀 저장")
    @Test
    fun save_success() {
        // given
        val name = "aaa"

        // when
        val team = sut.save(TeamJpaEntity(name = "aaa"))

        // then
        val savedTeam = sut.findById(team.id)
        Assertions.assertEquals(name, savedTeam.get().name)
    }

    @DisplayName("[findByName] 이름으로 조회")
    @Test
    fun findByName_success() {
        // given
        val name = "aaa"

        // when
        val teams = sut.findByNameSupport(name)

        // then
        Assertions.assertEquals(0, teams.size)
    }
}
