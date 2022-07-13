package domain

import domain.contract.DiseaseRepository
import domain.model.Disease

class CreateDiseaseFeature(
    private val diseaseRepository: DiseaseRepository,
    private val slugifyFeature: SlugifyFeature
) {

    fun create(disease: Disease): Result<Disease> {
        return runCatching {
            diseaseRepository.save(disease)
        }
    }

}