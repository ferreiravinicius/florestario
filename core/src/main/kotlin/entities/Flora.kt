package entities

data class Flora(
    val taxonomy: Taxonomy,
    val description: String,
    val popularName: String?,
    val commonNames: Set<String>
)