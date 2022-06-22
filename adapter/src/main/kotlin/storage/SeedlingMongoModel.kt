package storage

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.codecs.pojo.annotations.BsonProperty
import org.litote.kmongo.Id
import org.litote.kmongo.newId

class SeedlingMongoModel(
    @BsonId val id: Id<SeedlingMongoModel> = newId(),
    @BsonProperty("description") val description: String
)