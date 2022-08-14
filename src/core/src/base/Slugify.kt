package base

fun String.toSlug() = slugify(this)

fun slugify(text: String): String {
    val separator = "-"
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
    return sb.toString()
}
