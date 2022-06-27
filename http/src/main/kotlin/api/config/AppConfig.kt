package api.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import port.PestRepository
import postgres.PostgresPestRepository
import usecase.DescribePestUseCase

@Configuration
class AppConfig() {
    @Bean
    fun pestRepository() =
        PostgresPestRepository()
}

@Configuration
class UseCaseConfig(
    private val pestRepository: PestRepository
) {
    @Bean
    fun describePestilenceUseCase() =
        DescribePestUseCase(pestRepository)
}