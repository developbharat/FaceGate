package com.developbharat.facegate.domain.modules

import android.content.Context
import com.developbharat.facegate.domain.data.database.IVectorsDatabase
import com.developbharat.facegate.domain.data.database.VectorsDatabase
import com.developbharat.facegate.domain.ml.AIModel
import com.developbharat.facegate.domain.ml.IAIModel
import com.developbharat.facegate.domain.ml.facenet.FaceNetModel
import com.developbharat.facegate.domain.ml.facenet.IFaceNetModel
import com.developbharat.facegate.domain.models.settings.GlobalOptions
import com.developbharat.facegate.domain.repos.batch.BatchRepository
import com.developbharat.facegate.domain.repos.batch.IBatchRepository
import com.developbharat.facegate.domain.repos.device.DeviceState
import com.developbharat.facegate.domain.repos.device.IDeviceState
import com.developbharat.facegate.domain.repos.facedb.FaceDatabaseRepository
import com.developbharat.facegate.domain.repos.facedb.IFaceDatabaseRepository
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
    fun providesAIModel(faceNetModel: IFaceNetModel): IAIModel {
        return AIModel(faceNetModel = faceNetModel)
    }

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
    fun providesFaceNetModel(@ApplicationContext appContext: Context): IFaceNetModel {
        // TODO: dynamically load global options
        return FaceNetModel(appContext = appContext, globalOptions = GlobalOptions())
    }

    @Provides
    @Singleton
    fun providesVectorsDatabase(@ApplicationContext appContext: Context): IVectorsDatabase {
        return VectorsDatabase(appContext = appContext, dbPassword = "Password", dbName = "vectors.db")
    }

    @Provides
    @Singleton
    fun providesFaceDbRepository(database: IVectorsDatabase): IFaceDatabaseRepository {
        return FaceDatabaseRepository(database = database)
    }
}