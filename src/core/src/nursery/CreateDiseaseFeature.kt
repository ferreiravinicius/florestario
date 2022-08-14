package nursery

import base.slugify
import nursery.contract.DiseaseRepository
import nursery.entity.Disease

class DiseaseAlreadyExists : Exception()

class CreateDiseaseFeature(
    private val diseaseRepository: DiseaseRepository
) {
    fun create(disease: Disease): Result<Disease> {
        return runCatching {
            disease
                .apply { slug = slugify(name) }
                .apply { validateSlugAlreadyExists(slug) }
                .let { diseaseRepository.create(it) }
        }
    }

    private fun validateSlugAlreadyExists(slug: String) {
        if (diseaseRepository.exists(slug)) {
            throw DiseaseAlreadyExists()
        }
    }
}