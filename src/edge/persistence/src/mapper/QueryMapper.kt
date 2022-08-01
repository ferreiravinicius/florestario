package mapper

import org.ktorm.dsl.QueryRowSet

interface QueryMapper<D> {
    fun mapFrom(row: QueryRowSet): D
}