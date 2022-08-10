package core.entity

import common.emptyString

// TODO: List<Symptom>
// TODO: cause must be enum (or model)
class Disease(
    val name: String,
//    val cause: CauseGroup,
    val description: String,
    var slug: String = emptyString,
//    var symptoms: List<String> = emptyList(),
//    var organism: Optional<Organism> = Optional.empty() //causer
)

enum class CauseGroup {
    ANIMAL,
    PATHOGEN,
    ENVIRONMENT
}