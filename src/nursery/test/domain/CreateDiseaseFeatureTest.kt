package domain

import domain.contract.DiseaseRepository
import domain.model.Disease
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class CreateDiseaseFeatureTest {

    private lateinit var mockDiseaseRepository: DiseaseRepository
    private lateinit var createDiseaseFeature: CreateDiseaseFeature

    @BeforeEach
    fun beforeEach() {
        mockDiseaseRepository = mockk()
        createDiseaseFeature = CreateDiseaseFeature(mockDiseaseRepository)
    }

    @Test
    fun `must create slug before save`() {

        val disease = Disease(
            name = "super scientific name here",
            cause = "cause",
            description = "description"
        )


    }

}