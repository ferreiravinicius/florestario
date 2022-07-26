package api.controller.data

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import common.emptyString
import domain.model.CauseGroup
import domain.model.Disease

@JsonIgnoreProperties(ignoreUnknown = true)
data class CreateDiseaseData(
    val name: String,
    val cause: String,
    val description: String,
    val organismSlug: String,
    var slug: String?
)

class CreateDiseaseConverter : Converter<CreateDiseaseData, Disease> {
    override fun toData(entity: Disease): CreateDiseaseData {
        throw Exception()
    }

    override fun toEntity(data: CreateDiseaseData): Disease {
        return Disease(
            name = data.name,
            description = data.description,
            slug = data.slug ?: emptyString,
            cause = CauseGroup.valueOf(data.cause)
        )
    }
}

interface Converter<D, E> : DirectConverter<D, E> {
    fun toData(entity: E): D
}

interface DirectConverter<D, E> {
    fun toEntity(data: D): E
}