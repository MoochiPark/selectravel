package io.wisoft.daewon.member

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@RestController
@RequestMapping("/auth")
class AuthController(private val authService: AuthService) {

  @PostMapping("/login")
  fun login(@RequestBody member: Member) = authService.login(member)

  @PostMapping("/signup")
  fun signUp(@RequestBody member: Member) = authService.signUp(member)

}