package base

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

internal class IdTest {

    @Test
    fun `id`() {
        val id = TestId(123)
        assertFalse { id.equals(123) }
        assertFalse { id.equals(null) }
        assertTrue { id.equals(TestId(123)) }
    }
}

data class TestId(val value: Int) : Id<Int>(value)