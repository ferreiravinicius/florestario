package domain

class SlugifyFeature {

    private val trimDelimiter = " "
    private val joinSeparator = "-"

    fun slugify(scientificName: String): Result<String> {

       if (scientificName.isBlank()) {
           return Result.failure(Exception()) //todo: chance to checked exception
       }

        val slug = scientificName
            .trim()
            .split(trimDelimiter)
            .joinToString(joinSeparator) { it.lowercase() }

        return Result.success(slug)
    }
}

