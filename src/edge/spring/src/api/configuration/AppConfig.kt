package api.configuration

import api.controller.data.CreateDiseaseConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig() {

    @Bean
    fun createDiseaseConverter() = CreateDiseaseConverter()

//    @Bean
//    fun diseaseRepository() = DiseaseRepository

//    @Bean
//    fun createDiseaseFeature() = CreateDiseaseFeature()

}
