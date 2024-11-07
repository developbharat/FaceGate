package com.developbharat.facegate.coroutines

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.Constraints
import androidx.work.CoroutineWorker
import androidx.work.ExistingWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class DownloadFacenetModelWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters
) :
    CoroutineWorker(context, workerParams) {

    companion object {
        private const val NAME = "DOWNLOAD_FACENET_MODEL_WORKER"

        fun scheduleOneTimeTask(context: Context) {
            val workManager = WorkManager.getInstance(context)
            val constraints =
                Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).setRequiresBatteryNotLow(true)
                    .build()
            val downloadWork =
                OneTimeWorkRequestBuilder<DownloadFacenetModelWorker>().setConstraints(constraints).build()
            workManager.enqueueUniqueWork(this.NAME, ExistingWorkPolicy.REPLACE, downloadWork)
        }
    }

    override suspend fun doWork(): Result {
        Log.d("service", "Executing Download Facenet Model")
        return Result.success()
    }
}