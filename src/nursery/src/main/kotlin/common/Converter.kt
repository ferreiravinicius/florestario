package common

/**
 * Unilateral Converter
 *
 * @param F from (origin)
 * @param T to (target)
 */
interface Converter<F, T> {
    fun convert(from: F): T
}
