package storage

import com.mongodb.client.MongoDatabase
import entities.Seedling
import entities.Taxonomy
import org.litote.kmongo.getCollection
import ports.SeedlingStorage

class MongoSeedlingStorage(private val mongoDatabase: MongoDatabase) : SeedlingStorage {

    private val collectionName = "seedling"

    override fun save(seedling: Seedling): Result<Seedling> {
        val model = SeedlingMongoModel(description = seedling.description)
        mongoDatabase
            .getCollection<SeedlingMongoModel>(collectionName)
            .insertOne(model)
        seedling.id = model.id.toString()
        return Result.success(seedling)

    }


    override fun getAll(lastKey: Long, size: Long): List<Seedling> {
        return mongoDatabase
            .getCollection<SeedlingMongoModel>(collectionName)
            .find()
            .map { createSeedling(it.description) }
            .toList()
    }

    override fun findHavingSpecies(species: String): List<Seedling> {
        return emptyList()
    }
}

fun createSeedling(description: String): Seedling {
    return Seedling(
        commonNames = setOf("name"),
        description = description,
        popularName = "popularName",
        taxonomy = Taxonomy(
            genus = "genus",
            species = "species",
            variety = "variety"
        )
    )
}
