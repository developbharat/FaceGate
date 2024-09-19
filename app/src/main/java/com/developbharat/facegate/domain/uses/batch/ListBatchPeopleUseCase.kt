package com.developbharat.facegate.domain.uses.batch

import com.developbharat.facegate.common.Resource
import com.developbharat.facegate.domain.models.Person
import com.developbharat.facegate.domain.repos.batch.IBatchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ListBatchPeopleUseCase @Inject constructor(
    private val batchRepository: IBatchRepository
) {
    operator fun invoke(): Flow<Resource<List<Person>>> = flow {
        try {
            emit(Resource.ResourceInProgress("Loading Batch People"))
            val people = batchRepository.listBatchPeople()
            emit(Resource.ResourceSuccess(people, "Batch People loaded successfully."))
        } catch (ex: Exception) {
            emit(Resource.ResourceError(ex.localizedMessage ?: "Unknown Error occurred."))
        }
    }
}