package biology

import biology.contract.OrganismRepository
import biology.entity.Organism
import biology.model.CreateOrganismModel

class CreateOrganismFeature(
    private val organismRepository: OrganismRepository
) {
    fun create(organismModel: CreateOrganismModel): Result<Organism> {
        return runCatching {
            val organism = organismModel.toEntity()
            organismRepository.create(organism);
        }
    }
}
