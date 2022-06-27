package usecase

import error.NotFound
import io.PestDescribed
import port.PestRepository

class DescribePestUseCase(
    private val pestRepository: PestRepository
) {
    fun describe(slug: String): Result<PestDescribed> {
        val pest = pestRepository.findOne(slug)
        pest?.let { pest ->
            val pestDescribed = PestDescribed(
                name = pest.organism.name,
                description = pest.description,
                binomialName = pest.organism.scientificName
            )
            return Result.success(pestDescribed)
        }
        return Result.failure(NotFound())
    }
}