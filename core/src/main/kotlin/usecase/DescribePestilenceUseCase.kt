package usecase

import error.NotFound
import io.PestDescribed
import port.PestRepository

class DescribePestilenceUseCase(
    private val pestRepository: PestRepository
) {
    fun describe(slug: String): Result<PestDescribed> {
        val pest = pestRepository.findOne(slug)
        pest?.let {
            val pestDescribed = PestDescribed(it.name)
            return Result.success(pestDescribed)
        }
        return Result.failure(NotFound())
    }
}