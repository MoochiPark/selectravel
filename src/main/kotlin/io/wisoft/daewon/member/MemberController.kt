package io.wisoft.daewon.member

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

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

  @RequestMapping(value = ["{id}"], method = [RequestMethod.PUT])
  @ResponseStatus(HttpStatus.OK)
  fun updateMemberPoint(@RequestBody member: Member, @PathVariable id: Long): Long? {
    return memberService.updateMemberPoint(member, id)
  }


}