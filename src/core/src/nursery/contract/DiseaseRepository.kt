package nursery.contract

import nursery.entity.Disease

interface DiseaseRepository {
    fun findOneBySlug(slug: String): Disease?
    fun exists(slug: String): Boolean
    fun create(disease: Disease): Disease
}