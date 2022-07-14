package domain

import domain.contract.DiseaseRepository
import domain.model.Disease

class CreateDiseaseFeature(
    private val diseaseRepository: DiseaseRepository
) {
    fun create(disease: Disease): Result<Disease> {
        return runCatching {

            disease.slug = disease.name
                .trim()
                .split(" ")
                .joinToString("-")

            diseaseRepository.create(disease)
        }
    }
}