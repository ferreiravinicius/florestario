package biology.entity

import base.Id


/**
 * Organism: living form that functions as individual entity
 * todo: Feeding/consuming habits - carnivores, herbivores, omnivores, detritivores, and parasites (**** ONLY ANIMALS)
 */
class Organism(
    var id: OrganismId? = Id.empty,
    val name: String,
    val taxonomy: Taxonomy
)

data class OrganismId(val value: Long) : Id<Long>(value)
