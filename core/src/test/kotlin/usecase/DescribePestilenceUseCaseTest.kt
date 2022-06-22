package usecase

import entity.Pest
import error.NotFound
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import port.PestRepository
import kotlin.test.assertEquals

class DescribePestilenceUseCaseTest {

    private val mockPestRepository = mockk<PestRepository>()
    private val sut = DescribePestilenceUseCase(mockPestRepository)


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
        val pestMock = Pest("pestMock")
        every { mockPestRepository.findOne(any()) }.returns(pestMock)
        val result = sut.describe("slug")
        assert(result.isSuccess)
        assertEquals(pestMock.name, result.getOrThrow().name)
    }

}