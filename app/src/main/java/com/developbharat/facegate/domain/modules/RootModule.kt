package com.developbharat.facegate.domain.modules

import android.content.Context
import com.developbharat.facegate.domain.repos.batch.BatchRepository
import com.developbharat.facegate.domain.repos.batch.IBatchRepository
import com.developbharat.facegate.domain.repos.device.DeviceState
import com.developbharat.facegate.domain.repos.device.IDeviceState
import com.developbharat.facegate.domain.repos.facematch.FaceMatchRepository
import com.developbharat.facegate.domain.repos.facematch.IFaceMatchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RootModule {

    @Provides
    @Singleton
    fun providesBatchRepository(): IBatchRepository {
        return BatchRepository()
    }

    @Provides
    @Singleton
    fun providesDeviceState(@ApplicationContext appContext: Context): IDeviceState {
        return DeviceState(appContext)
    }

    @Provides
    @Singleton
    fun providesFaceMatchRepository(): IFaceMatchRepository {
        return FaceMatchRepository()
    }
}