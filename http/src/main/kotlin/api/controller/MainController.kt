package api.controller

import io.PestDescribed
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import usecase.DescribePestilenceUseCase

@RestController
class MainController(
    val describePestilenceUseCase: DescribePestilenceUseCase
) {

    @GetMapping("ping")
    fun describe(): PestDescribed {
        val result = describePestilenceUseCase.describe("none")
        return result.getOrThrow()
    }
}