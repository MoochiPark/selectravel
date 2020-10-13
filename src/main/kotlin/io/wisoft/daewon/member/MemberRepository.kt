package io.wisoft.daewon.member

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository : JpaRepository<Member, Long> {
  fun findByEmail(email: String): Member?
  fun findByEmailAndPassword(email: String, password:String): Member?
  fun existsByEmail(email: String): Boolean
}