package io.wisoft.daewon.member

import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity
data class Member(
  @Id @GeneratedValue(strategy = IDENTITY)
  val id: Long? = null,
  val name: String? = null,
  val email: String? = null,
  val password: String? = null,
  var point: Long? = 0
) {
//  internal fun create() = Member(name = name, email = email, password = password)
}