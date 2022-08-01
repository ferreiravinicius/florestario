import common.emptyString
import domain.model.Disease
import org.flywaydb.core.Flyway
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.ktorm.database.Database
import org.ktorm.dsl.*
import record.DiseaseTable
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class KtormDiseaseRepositoryTest {

    private val url = "jdbc:h2:mem:florestario;DB_CLOSE_DELAY=-1"
    private val database = Database.connect(url)
    private val diseaseRepository = KtormDiseaseRepository(database)

    @BeforeAll
    fun beforeAll() {
        val flyway = Flyway
            .configure()
            .locations("filesystem:./migrations")
            .dataSource(url, emptyString, emptyString)
            .load()

        flyway.migrate()
    }

    @Test
    fun `check connection`() {
        assertTrue { database.productName == "H2" }
    }

    @Test
    fun `exists must check if slug already exists`() {

        val slug = "slug-test"

        database.deleteAll(DiseaseTable)
        database.insert(DiseaseTable) {
            set(it.name, "name")
            set(it.description, "description")
            set(it.slug, slug)
        }

        assertTrue { diseaseRepository.exists(slug) }
        assertFalse { diseaseRepository.exists("another-slug") }
    }

    @Test
    fun `create given disease must save`() {

        database.deleteAll(DiseaseTable)

        val disease = Disease(
            slug = "disease-slug",
            name = "disease name",
            description = "disease description"
        )
        val result = diseaseRepository.create(disease)

        assertEquals(disease, result)

        val diseaseCount = database.from(DiseaseTable)
            .select(DiseaseTable.slug)
            .where { DiseaseTable.slug eq disease.slug }
            .totalRecords
        assertTrue { diseaseCount > 0 }
    }
}