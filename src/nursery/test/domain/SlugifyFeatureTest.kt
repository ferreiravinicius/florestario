package domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class SlugifyFeatureTest {

    private lateinit var slugifyFeature: SlugifyFeature

    @BeforeEach
    fun beforeEach() {
        slugifyFeature = SlugifyFeature()
    }

    @Test
    fun `must slugify`() {
        assertEquals("test", slugifyFeature.slugify(" test ").getOrThrow())
        assertEquals("test-test-test", slugifyFeature.slugify("TEST tEst Test").getOrThrow())
        assertEquals("test-test", slugifyFeature.slugify(" test    test").getOrThrow())
        assertEquals("test-test", slugifyFeature.slugify(" te4st  4#  test").getOrThrow())
    }

}