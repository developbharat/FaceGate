package com.developbharat.facegate.domain.repos.people

import com.developbharat.facegate.domain.models.Person

interface IPeopleRepository {
    suspend fun listPeople(batchId: Int): List<Person>
    suspend fun createPeople(batchId: Int, vararg people: Person)
    suspend fun deletePerson(person: Person)
}