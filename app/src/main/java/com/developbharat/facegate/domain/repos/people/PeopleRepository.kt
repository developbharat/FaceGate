package com.developbharat.facegate.domain.repos.people

import com.developbharat.facegate.domain.data.database.MainDatabase
import com.developbharat.facegate.domain.models.Person
import javax.inject.Inject

class PeopleRepository @Inject constructor(private val db: MainDatabase) : IPeopleRepository {
    override suspend fun listPeople(batchId: Int): List<Person> {
        return db.peopleDao().list(batchId).map { it.toPerson() }
    }

    override suspend fun createPeople(batchId: Int, vararg people: Person) {
        db.peopleDao().create(*people.map { it.copy(batchId = batchId).toPeopleRecord() }.toTypedArray())
    }

    override suspend fun deletePerson(person: Person) {
        db.peopleDao().delete(person.toPeopleRecord())
    }
}