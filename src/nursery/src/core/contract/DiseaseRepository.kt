package core.contract

import core.entity.Disease

interface DiseaseRepository {
    fun findOneBySlug(slug: String): Disease?
    fun exists(slug: String): Boolean
    fun create(disease: Disease): Disease
}