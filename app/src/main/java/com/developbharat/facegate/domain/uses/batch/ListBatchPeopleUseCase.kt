package com.developbharat.facegate.domain.uses.batch

import com.developbharat.facegate.common.Resource
import com.developbharat.facegate.domain.models.Person
import com.developbharat.facegate.domain.repos.device.IDeviceState
import com.developbharat.facegate.domain.repos.people.IPeopleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ListBatchPeopleUseCase @Inject constructor(
    private val deviceState: IDeviceState,
    private val peopleRepository: IPeopleRepository
) {
    operator fun invoke(): Flow<Resource<List<Person>>> = flow {
        try {
            emit(Resource.ResourceInProgress("Loading Batch People"))
            val batchId = deviceState.useGlobalOptions().selectedBatchId
            if (batchId == null) throw Exception("No batch selected. Please select a batch in settings.")

            val people = peopleRepository.listPeople(batchId = batchId.toInt())
            emit(Resource.ResourceSuccess(people, "Batch People loaded successfully."))
        } catch (ex: Exception) {
            emit(Resource.ResourceError(ex.localizedMessage ?: "Unknown Error occurred."))
        }
    }
}