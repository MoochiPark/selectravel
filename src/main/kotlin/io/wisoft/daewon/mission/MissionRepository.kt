package io.wisoft.daewon.mission

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MissionRepository : JpaRepository<Mission, Long> {
}