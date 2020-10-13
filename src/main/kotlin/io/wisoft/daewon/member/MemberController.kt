package io.wisoft.daewon.member

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/members")
class MemberController(private val memberService: MemberService) {

  @GetMapping
  fun findAll(): MutableIterable<Member> =
    memberService.findAll()

  @GetMapping("/{id}")
  fun findById(@PathVariable id: Long): Member? =
    memberService.findById(id)

  @GetMapping("/{email}")
  fun findByEmail(@PathVariable email: String): Member? =
    memberService.findByEmail(email)

}