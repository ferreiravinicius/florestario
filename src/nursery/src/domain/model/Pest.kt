package domain.model

/*
> Plant Pest: Cochonilha-carapaca
> Binomial Name: C. chobuss
> Variety Of: Cochonilha
> Class: Inseto
> Sintomas: ...
*/

class Pest(
    val organism: Organism,
    val description: String
)

class InvasiveSpecies(
    val description: String,
    val organism: Organism
)

class Organism(
    val name: String,
    val scientificName: String //TODO: maybe use taxonomy and list of common names
)


//Fungi, Nematodes, Bacteria, Parasite, Viruses
/**
 * Plant Disease
 *
 * - Causer Group: Pathogens, Enviromental Conditions ?plants, animals, insects
 *
 * Pathogens
 * -Type: Nematodes, Algae, Bacteria, Fungi, Parasites, Viruses
 *
 * Environmental Condition
 * - Type: Excessive Rain, Fog, Snow

eg.:

> Plant Disease: Míldio
> Description: Fungo na videira que lorem...
> Causer: Fungo
> Group: Patogenos
> Sintomas: ...

 *
 */
