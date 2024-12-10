package com.developbharat.facegate.domain.modules

import android.content.Context
import com.developbharat.facegate.domain.data.database.MainDatabase
import com.developbharat.facegate.domain.data.vectors.IVectorsDatabase
import com.developbharat.facegate.domain.data.vectors.VectorsDatabase
import com.developbharat.facegate.domain.ml.AIModel
import com.developbharat.facegate.domain.ml.IAIModel
import com.developbharat.facegate.domain.ml.facenet.FaceNetModel
import com.developbharat.facegate.domain.ml.facenet.IFaceNetModel
import com.developbharat.facegate.domain.repos.batch.BatchRepository
import com.developbharat.facegate.domain.repos.batch.IBatchRepository
import com.developbharat.facegate.domain.repos.device.DeviceState
import com.developbharat.facegate.domain.repos.device.IDeviceState
import com.developbharat.facegate.domain.repos.facedb.FaceDatabaseRepository
import com.developbharat.facegate.domain.repos.facedb.IFaceDatabaseRepository
import com.developbharat.facegate.domain.repos.people.IPeopleRepository
import com.developbharat.facegate.domain.repos.people.PeopleRepository
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
    fun providesDeviceState(@ApplicationContext appContext: Context): IDeviceState {
        return DeviceState(appContext)
    }

    @Provides
    @Singleton
    fun providesFaceNetModel(@ApplicationContext appContext: Context): IFaceNetModel {
        return FaceNetModel(appContext = appContext)
    }

    @Provides
    @Singleton
    fun providesVectorsDatabase(@ApplicationContext appContext: Context): IVectorsDatabase {
        // TODO: add password generation dynamic logic
        return VectorsDatabase(appContext = appContext, dbPassword = "Password", dbName = "vectors.db")
    }

    @Provides
    @Singleton
    fun providesFaceDbRepository(
        vectorsDb: IVectorsDatabase,
        mainDb: MainDatabase,
        deviceState: IDeviceState
    ): IFaceDatabaseRepository {
        return FaceDatabaseRepository(vectorsDatabase = vectorsDb, mainDatabase = mainDb, deviceState = deviceState)
    }

    @Provides
    @Singleton
    fun providesMainDatabase(@ApplicationContext appContext: Context): MainDatabase {
        return MainDatabase.createInstance(appContext)
    }

    @Provides
    @Singleton
    fun providesBatchRepository(db: MainDatabase): IBatchRepository {
        return BatchRepository(db)
    }

    @Provides
    @Singleton
    fun providesPeopleRepository(db: MainDatabase): IPeopleRepository {
        return PeopleRepository(db)
    }
}