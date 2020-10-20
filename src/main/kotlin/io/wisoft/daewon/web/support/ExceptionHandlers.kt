package io.wisoft.daewon.web.support

import io.wisoft.daewon.exception.ImageNotFoundException
import io.wisoft.daewon.exception.MemberAlreadyExistsException
import io.wisoft.daewon.exception.MemberInfoIncorrectException
import io.wisoft.daewon.web.support.ErrorResponse.ErrorResponseEntity.Companion.badRequest
import io.wisoft.daewon.web.support.ErrorResponse.ErrorResponseEntity.Companion.notFound
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.net.MalformedURLException

@ControllerAdvice
class ExceptionHandlers {

  @ExceptionHandler(MemberAlreadyExistsException::class)
  fun memberAlreadyExists(exception: MemberAlreadyExistsException) = exception.message?.let { badRequest(it) }

  @ExceptionHandler(MemberInfoIncorrectException::class)
  fun memberNotFoundException(exception: MemberInfoIncorrectException) = exception.message?.let { badRequest(it) }

  @ExceptionHandler(MalformedURLException::class, ImageNotFoundException::class)
  fun imageNotFoundException(exception: ImageNotFoundException) = exception.message?.let { notFound(it) }
}
