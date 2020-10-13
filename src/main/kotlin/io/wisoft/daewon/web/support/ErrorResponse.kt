package io.wisoft.daewon.web.support

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity
import org.springframework.util.MultiValueMap
import java.util.*

data class ErrorResponse(
  val status: HttpStatus,
  val error: String = status.reasonPhrase,
  val message: String,
  val timestamp: Date = Date(),
  val bindingErrors: List<String> = ArrayList<String>()
) {

  class ErrorResponseEntity : ResponseEntity<ErrorResponse> {

    constructor(body: ErrorResponse) : super(body, body.status)
    constructor(body: ErrorResponse, headers: MultiValueMap<String, String>) : super(body, headers, body.status)

    companion object {
      fun badRequest(message: String) = ErrorResponseEntity(ErrorResponse(status = BAD_REQUEST, message = message))
      fun badRequest(message: String, bindingErrors: List<String>) =
        ErrorResponseEntity(ErrorResponse(status = BAD_REQUEST, message = message, bindingErrors = bindingErrors))

      fun notFound(message: String) = ErrorResponseEntity(ErrorResponse(status = NOT_FOUND, message = message))
      fun serverError(message: String) =
        ErrorResponseEntity(ErrorResponse(status = INTERNAL_SERVER_ERROR, message = message))
    }

  }

}