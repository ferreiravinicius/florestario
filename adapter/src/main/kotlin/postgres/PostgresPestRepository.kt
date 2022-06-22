package postgres

import entity.Pest
import port.PestRepository

class PostgresPestRepository : PestRepository {
    override fun findOne(slug: String): Pest? {
        return Pest("fakeName")
    }
}