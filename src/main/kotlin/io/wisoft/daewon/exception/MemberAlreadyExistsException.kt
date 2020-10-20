package io.wisoft.daewon.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

class MemberAlreadyExistsException(override val message: String?) : Exception(message) {
}