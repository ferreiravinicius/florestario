package biology.contract

import biology.entity.Organism

interface OrganismRepository {
    fun create(organism: Organism): Organism
}