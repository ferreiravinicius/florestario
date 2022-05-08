import entities.Flora

interface RegisterFloraContract {
    fun register(flora: Flora): Result<Flora>
}