package io.wisoft.daewon.mission

import io.wisoft.daewon.member.Member
import org.springframework.core.io.Resource
import org.springframework.data.domain.Page
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/travels/missions")
class MissionController(private val missionService: MissionService) {

  @GetMapping
  fun findAll(): Page<Mission> = missionService.findAll()

  @GetMapping("/{id}/image")
  fun findImageById(@PathVariable id: Long, locale: Locale): ResponseEntity<Resource> {
    val questImage = missionService.findImageById(id)
    return ResponseEntity.ok()
      .header(
        HttpHeaders.CONTENT_DISPOSITION,
        "attachment; filename=\"" + questImage.filename + "\""
      )
      .body(questImage)
  }


}