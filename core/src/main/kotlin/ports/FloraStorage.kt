package ports

import entities.Flora

interface FloraStorage {
    fun save(flora: Flora)
}