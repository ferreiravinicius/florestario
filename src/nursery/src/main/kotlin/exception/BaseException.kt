package exception

sealed class BaseException(
    val messageKey: String,
    vararg argKeys: String
) : RuntimeException()
