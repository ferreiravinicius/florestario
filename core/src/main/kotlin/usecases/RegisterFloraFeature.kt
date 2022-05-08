package usecases

import RegisterFloraContract
import entities.Flora
import ports.FloraStorage

class RegisterFloraFeature(
    private val floraStorage: FloraStorage,
    private val validators: Validators
) : RegisterFloraContract {
    override fun register(flora: Flora): Result<Flora> {
        return runCatching {
            validators.flora(flora)
            floraStorage.save(flora)
            flora
        }
    }
}

interface Validators {
    fun flora(flora: Flora)
}