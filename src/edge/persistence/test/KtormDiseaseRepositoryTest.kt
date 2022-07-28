import common.emptyString
import org.flywaydb.core.Flyway
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.ktorm.database.Database
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

}