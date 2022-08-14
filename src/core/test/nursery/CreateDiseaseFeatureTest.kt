package nursery

import io.mockk.every
import io.mockk.mockk
import nursery.contract.DiseaseRepository
import nursery.entity.Disease
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertTrue

internal class CreateDiseaseFeatureTest {

    private lateinit var mockDiseaseRepository: DiseaseRepository
    private lateinit var createDiseaseFeature: CreateDiseaseFeature

    @BeforeEach
    fun beforeEach() {
        mockDiseaseRepository = mockk()
        createDiseaseFeature = CreateDiseaseFeature(mockDiseaseRepository)
    }

    @Test
    fun `must create disease with success`() {

        val disease = generateDisease()

        every { mockDiseaseRepository.exists(any()) }.returns(false)
        every { mockDiseaseRepository.create(any()) }.returns(disease)

        val result = createDiseaseFeature.create(disease)
        assertTrue { result.isSuccess }
    }

    @Test
    fun `must fail if slug already exists`() {
        every { mockDiseaseRepository.exists(any()) }.returns(true)

        val result = createDiseaseFeature.create(generateDisease())
        assertTrue { result.isFailure }
        assertThrows<DiseaseAlreadyExists> { result.getOrThrow() }
    }

    private fun generateDisease(): Disease {
        return Disease(
            name = "super scientific name here",
            description = "description"
        )
    }
}