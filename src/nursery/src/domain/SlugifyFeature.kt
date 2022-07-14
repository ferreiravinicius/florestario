package domain

class CannotSlugifyBlankText : Exception()

class SlugifyFeature {

    private val separator = "-"

    fun slugify(text: String): Result<String> {

        if (text.isBlank()) {
            return Result.failure(CannotSlugifyBlankText())
        }

        val sb = StringBuilder()
        var awaitingSeparator = false
        for (i in text.indices) {

            val char = text.elementAt(i)

            if (char.isLetter()) {
                sb.append(char.lowercase())
                awaitingSeparator = true
            } else if (char.isWhitespace() && awaitingSeparator) {
                text.elementAtOrNull(i + 1)?.let { nextChar ->
                    if (nextChar.isLetter()) {
                        sb.append(separator)
                        awaitingSeparator = false
                    }
                }
            }
        }

        return Result.success(sb.toString())
    }
}

