package io.wisoft.daewon.member

import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity
data class Member(
  @Id @GeneratedValue(strategy = IDENTITY)
  val id: Long? = null,
  val name: String?,
  val email: String,
  val password: String,
  val point: Long? = 0
) {
  internal fun create() = Member(name = name, email = email, password = password)
}