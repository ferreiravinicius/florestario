package api.controller

import api.controller.data.CreateDiseaseConverter
import api.controller.data.CreateDiseaseData
import core.CreateDiseaseFeature
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController(value = "disease")
class DiseaseController {

    @Autowired
    private lateinit var diseaseConverter: CreateDiseaseConverter
    private lateinit var createDiseaseFeature: CreateDiseaseFeature

    @PostMapping
    fun create(diseaseData: CreateDiseaseData): CreateDiseaseData {
        return diseaseData
            .let { diseaseConverter.toEntity(it) }
            .let { createDiseaseFeature.create(it) }
            .map { diseaseConverter.toData(it) }
            .getOrThrow()
    }

}