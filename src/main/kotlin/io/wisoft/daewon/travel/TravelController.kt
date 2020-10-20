package io.wisoft.daewon.travel

import io.wisoft.daewon.member.Member
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/travels")
class TravelController(private val travelService: TravelService) {


}