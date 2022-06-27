package api.controller

import io.PestDescribed
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import usecase.DescribePestUseCase

@RestController
class MainController(
    val describePestUseCase: DescribePestUseCase
) {

    @GetMapping("ping")
    fun describe(): PestDescribed {
        val result = describePestUseCase.describe("none")
        return result.getOrThrow()
    }
}