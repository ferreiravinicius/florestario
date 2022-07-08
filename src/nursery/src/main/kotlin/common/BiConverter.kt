package common

/**
 * Bilateral Converter
 *
 * @param F from (origin)
 * @param T to (target)
 */
interface BiConverter<F, T> : Converter<F, T> {
    fun reverseConvert(target: T): F
}
