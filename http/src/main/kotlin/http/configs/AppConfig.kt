package http.configs

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ports.SeedlingStorage
import usecases.CreatePlantExecutor
import usecases.Validator
import validator.SimpleValidator

@Configuration
class AppConfig(
    val seedlingStorage: SeedlingStorage,
    val validator: Validator
) {
    @Bean
    fun createFloraUseCase(): CreatePlantUseCase =
        CreatePlantExecutor(seedlingStorage, validator)
}

@Configuration
class AdapterConfig {
    @Bean
    fun validator(): Validator = SimpleValidator()

    @Bean
    fun floraStorage(): SeedlingStorage = MemorySeedlingStorage()
}