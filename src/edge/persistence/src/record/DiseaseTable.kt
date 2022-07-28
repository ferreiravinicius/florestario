package record

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.long
import org.ktorm.schema.varchar

object DiseaseTable : Table<DiseaseRecord>("t_disease") {
   val id = long("id").primaryKey().bindTo { it.id }
   val name = varchar("name").bindTo { it.name }
   val slug = varchar("slug").bindTo { it.slug }
   val cause = varchar("cause").bindTo { it.cause }
   val description = varchar("description").bindTo { it.description }
}

interface DiseaseRecord : Entity<DiseaseRecord> {
   val id: Long
   var name: String
   var slug: String
   var cause: String
   var description: String

   // factory
   companion object : Entity.Factory<DiseaseRecord>()
}
