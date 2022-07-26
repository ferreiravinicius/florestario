package domain

import domain.contract.DiseaseRepository
import domain.model.Disease

class DiseaseAlreadyExists : Exception()

class CreateDiseaseFeature(
    private val diseaseRepository: DiseaseRepository
) {
    fun create(disease: Disease): Result<Disease> {
        return runCatching {
            disease
                .apply { slug = slugify(name) }
                .apply { validateAlreadyExists(slug) }
                .let { diseaseRepository.create(it) }
        }
    }

    private fun validateAlreadyExists(slug: String) {
        if (diseaseRepository.exists(slug)) {
            throw DiseaseAlreadyExists()
        }
    }
}