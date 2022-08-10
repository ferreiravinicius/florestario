package core

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SlugifyFeatureTest {

    @Test
    fun `given name must slugify with success`() {
        assertEquals("test", slugify(" test "))
        assertEquals("test-test-test", slugify("TEST tEst Test"))
        assertEquals("test-test", slugify(" test    test"))
        assertEquals("test-test", slugify(" te4st  4#  test"))
    }

    @Test
    fun `given blank string must return blank string`() {
        assertEquals("", slugify("  "))
        assertEquals("", slugify(""))
        assertEquals("", "".toSlug())
    }
}