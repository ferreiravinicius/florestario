package error

abstract class ConstraintViolation(message: String) : Exception(message)
class NotFound(vararg args: String) : Throwable()
