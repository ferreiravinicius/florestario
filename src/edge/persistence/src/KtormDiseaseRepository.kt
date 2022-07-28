import domain.contract.DiseaseRepository
import domain.model.CauseGroup
import domain.model.Disease
import org.ktorm.database.Database
import org.ktorm.dsl.*
import record.DiseaseTable

interface QueryMapper<D> {
    fun mapFrom(row: QueryRowSet): D
}

class DiseaseQueryMapper : QueryMapper<Disease> {
    override fun mapFrom(row: QueryRowSet): Disease {
        return Disease(
            description = row[DiseaseTable.description]!!,
            name = row[DiseaseTable.name]!!,
            slug = row[DiseaseTable.slug]!!,
            cause = CauseGroup.PATHOGEN //todo: parse correctly
        )
    }
}

class KtormDiseaseRepository(
    private val database: Database,
    private var diseaseQueryMapper: QueryMapper<Disease> = DiseaseQueryMapper()
) : DiseaseRepository {

    override fun findOneBySlug(slug: String): Disease? {
        return database
            .from(DiseaseTable)
            .selectDistinct()
            .where { DiseaseTable.slug eq slug }
            .map { diseaseQueryMapper.mapFrom(it) }
            .firstOrNull()
    }

    override fun exists(slug: String): Boolean {
        return database
            .from(DiseaseTable)
            .select(DiseaseTable.id)
            .where(DiseaseTable.slug.eq(slug))
            .totalRecords > 0
    }

    override fun create(disease: Disease): Disease {
        database.useTransaction {
            database.insert(DiseaseTable) {
                set(it.slug, disease.slug)
                set(it.name, disease.name)
                set(it.description, disease.description)
                //todo: insert others
            }
        }
        return disease
    }
    
}