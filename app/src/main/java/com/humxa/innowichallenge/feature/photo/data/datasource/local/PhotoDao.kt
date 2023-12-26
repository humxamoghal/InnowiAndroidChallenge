package com.humxa.innowichallenge.feature.photo.data.datasource.local

import androidx.room.*
import com.humxa.innowichallenge.feature.photo.domain.model.PhotoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PhotoDao {

    @Query("SELECT * FROM photoentity")
    suspend fun getPhotos(): List<PhotoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPhotos(photos: List<PhotoEntity>): LongArray

}