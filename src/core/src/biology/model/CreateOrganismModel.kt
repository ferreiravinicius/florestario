package biology.model

import biology.entity.Organism
import biology.entity.Taxonomy

data class CreateOrganismModel(
    val name: String,
    val taxonomy: Taxonomy
) : Model<CreateOrganismModel, Organism> {
    
    override fun toEntity() = Organism(
        name = this.name,
        taxonomy = this.taxonomy
    )
}

interface Model<M, E> {
    fun toEntity(): E
}

interface ModelFactory<M, E> {
    fun fromEntity(entity: E): M
}
