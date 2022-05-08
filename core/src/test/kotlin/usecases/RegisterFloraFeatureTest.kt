package usecases

import entities.Flora
import entities.Taxonomy
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import ports.FloraStorage

internal class RegisterFloraFeatureTest {

    private val floraStorageMock = mockk<FloraStorage>()
    private val validatorsMock = mockk<Validators>()
    private val sut = RegisterFloraFeature(floraStorageMock, validatorsMock)

    @BeforeEach
    fun beforeEach() {
        every { floraStorageMock.save(any()) }.returns(Unit)
        every { validatorsMock.flora(any()) }.returns(Unit)
    }

    @Test
    fun `must save flora at storage`() {
        val flora = createFlora()
        val result = sut.register(flora)
        assert(result.isSuccess)
    }

    @Test
    fun `must validate flora before save`() {
        every { validatorsMock.flora(any()) }.throws(Exception())
        val flora = createFlora()
        val result = sut.register(flora)
        assert(result.isFailure)
    }

    private fun createFlora(): Flora {
        return Flora(
            description = "description",
            commonNames = setOf("commonName"),
            popularName = "popularName",
            taxonomy = createTaxonomy()
        )
    }

    private fun createTaxonomy(): Taxonomy {
        return Taxonomy(
            genus = "genus",
            species = "species",
            variety = "variety"
        )
    }
}