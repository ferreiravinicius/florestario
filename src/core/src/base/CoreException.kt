package base

abstract class CoreException(
    val messageKey: String,
    vararg argKeys: String
) : RuntimeException()
