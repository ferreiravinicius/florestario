import mapper.DiseaseQueryMapper
import mapper.QueryMapper
import nursery.contract.DiseaseRepository
import nursery.entity.Disease
import org.ktorm.database.Database
import org.ktorm.dsl.*
import record.DiseaseTable

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
            }
        }
        return disease
    }

}