package biology.entity

/**
 * Taxonomy (Rank): Biological Classification
 * Kingdom > ... > Genus > Species > Subspecies > Variety
 */
class Taxonomy(
    val kingdom: Kingdom,
    val genus: String,
    val species: String,
    val subspecies: String?,
    val variety: String?
)
