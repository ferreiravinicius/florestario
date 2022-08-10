package core.model

import core.entity.Organism
import core.entity.Taxonomy

data class CreateOrganismModel(
    val name: String,
    val taxonomy: Taxonomy
)

class CreateOrganismConverter : Converter<CreateOrganismModel, Organism> {
    override fun convert(source: CreateOrganismModel): Organism {
        return Organism(
            name = source.name,
            taxonomy = source.taxonomy
        )
    }
}

//TODO: create commons package
interface Converter<S, T> {
    fun convert(source: S): T
}