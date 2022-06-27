package usecase

import entity.Organism
import entity.Pest
import error.NotFound
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import port.PestRepository
import kotlin.test.assertEquals

class DescribePestUseCaseTest {

    private val mockPestRepository = mockk<PestRepository>()
    private val sut = DescribePestUseCase(mockPestRepository)


    @Test
    fun `must result error when pest slug is not found`() {
        every { mockPestRepository.findOne(any()) }.returns(null)
        val result = sut.describe("slug")
        assert(result.isFailure)
        assertThrows<NotFound> {
            result.getOrThrow()
        }
    }

    @Test
    fun `must result success when pest slug is found`() {
        val pestRepositoryResult = Pest(
            description = "description",
            organism = Organism(
               name = "organismName",
               scientificName = "organismScientificName",
            )
        )
        every { mockPestRepository.findOne(any()) }.returns(pestRepositoryResult)
        val result = sut.describe("slug")
        assert(result.isSuccess)
        assertEquals(pestRepositoryResult.description, result.getOrThrow().description)
        assertEquals(pestRepositoryResult.organism.name, result.getOrThrow().name)
    }

}