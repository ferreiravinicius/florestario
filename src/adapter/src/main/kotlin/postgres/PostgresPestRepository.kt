package postgres

import entity.Organism
import entity.Pest
import port.PestRepository

private val pests = mapOf(
    "cochonilha-farinhenta" to Pest(
        description = "Um tipo de cochonilha",
        organism = Organism(
            name = "Cochonilha Farinhenta",
            scientificName = "Coccus Chonilha"
        )
    )
)

class PostgresPestRepository : PestRepository {
    override fun findOne(slug: String): Pest? {
        return pests[slug]
    }
}