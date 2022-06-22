package port

import entity.Pest

interface PestRepository {
    fun findOne(slug: String): Pest?
}