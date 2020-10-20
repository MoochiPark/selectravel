package io.wisoft.daewon.mission

import io.wisoft.daewon.exception.ImageNotFoundException
import org.springframework.core.io.Resource
import org.springframework.core.io.UrlResource
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.nio.file.Paths

@Service
class MissionService(private val missionRepository: MissionRepository) {
  fun findAll(): Page<Mission> {
    return missionRepository.findAll(Pageable.unpaged())
  }

  fun findImageById(id: Long): Resource {
    val byId = missionRepository.getOne(id)
    val filePath = Paths.get(byId.image).normalize()
    val resource = UrlResource(filePath.toUri())

    if (!resource.exists()) throw ImageNotFoundException("이미지 파일을 찾을 수 없습니다.")
    return resource
  }


}