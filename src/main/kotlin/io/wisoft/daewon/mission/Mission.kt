package io.wisoft.daewon.mission

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.*
import javax.persistence.Id

@Entity
data class Mission(
  @Id
  @GeneratedValue(strategy = IDENTITY)
  val id: Long? = null,
  val title: String?,
  val description: String?,
  val company: String?,
  val image: String,
  val duration: String,
  val isProgress: Boolean? = true
) {
  internal fun create() =
    Mission(title = title, description = description, company = company, duration = duration, image = image)
}
