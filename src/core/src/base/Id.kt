package base

abstract class Id<T>(private val value: T) {
    override fun hashCode() = value.hashCode()
    override fun toString() = value.toString()
    override fun equals(other: Any?) = value == other

    companion object {
        val empty = null
    }
}