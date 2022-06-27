package api.handler

import error.NotFound
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionControllerAdvice {
    @ExceptionHandler
    fun handleNotFound(ex: NotFound): ResponseEntity<ErrorResponse> {
        val response = ErrorResponse(
            userMessage = "Not found"
        )
        return ResponseEntity(response, HttpStatus.NOT_FOUND)
    }
}

data class ErrorResponse(
    val userMessage: String
)