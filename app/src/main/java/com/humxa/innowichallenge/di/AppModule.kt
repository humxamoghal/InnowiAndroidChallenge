package com.humxa.innowichallenge.di

import android.app.Application
import androidx.room.Room
import com.humxa.innowichallenge.feature.photo.data.datasource.local.PhotoDatabase
import com.humxa.innowichallenge.feature.photo.data.datasource.remote.ApiService
import com.humxa.innowichallenge.feature.photo.data.repository.PhotoRepositoryImpl
import com.humxa.innowichallenge.feature.photo.domain.repository.PhotoRepository
import com.humxa.innowichallenge.feature.photo.domain.usecase.DownloadPhotosUseCase
import com.humxa.innowichallenge.feature.photo.domain.usecase.GetPhotosTableDataUseCase
import com.humxa.innowichallenge.feature.photo.domain.usecase.PhotosUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    /**
     * Ignored securing base url here coz there is not way to which make hundred percent secure it
     * reference: https://stackoverflow.com/a/47174382
     * We could add some berries like saving in config files and in encrypted form, but again
     * neither 100% secure nor part of this assignment
     */
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    @Provides
    @Singleton
    fun provideRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun providePhotoDatabase(app: Application): PhotoDatabase {
        return Room.databaseBuilder(
            app,
            PhotoDatabase::class.java,
            PhotoDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providePhotoRepository(db: PhotoDatabase, apiService: ApiService): PhotoRepository {
        return PhotoRepositoryImpl(db.photoDatabase, apiService)
    }

    @Provides
    @Singleton
    fun providePhotoUseCases(repository: PhotoRepository): PhotosUseCases {
        return PhotosUseCases(
            downloadPhotos = DownloadPhotosUseCase(repository),
            getTableData = GetPhotosTableDataUseCase()
        )
    }

}