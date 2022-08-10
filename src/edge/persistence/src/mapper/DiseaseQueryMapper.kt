package mapper

import core.entity.Disease
import org.ktorm.dsl.QueryRowSet
import record.DiseaseTable

class DiseaseQueryMapper : QueryMapper<Disease> {
    override fun mapFrom(row: QueryRowSet): Disease {
        return Disease(
            description = row[DiseaseTable.description]!!,
            name = row[DiseaseTable.name]!!,
            slug = row[DiseaseTable.slug]!!,
        )
    }
}