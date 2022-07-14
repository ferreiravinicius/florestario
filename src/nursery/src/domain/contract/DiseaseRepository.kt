package domain.contract

import domain.model.Disease

interface DiseaseRepository {
    fun findOneBySlug(slug: String): Disease?
    fun create(disease: Disease): Disease
}