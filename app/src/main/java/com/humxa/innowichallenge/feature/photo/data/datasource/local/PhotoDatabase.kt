package com.humxa.innowichallenge.feature.photo.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.humxa.innowichallenge.feature.photo.domain.model.PhotoEntity

@Database(
    entities = [PhotoEntity::class],
    version = 1
)
abstract class PhotoDatabase : RoomDatabase() {

    abstract val photoDatabase: PhotoDao

    companion object {
        const val DATABASE_NAME = "photos_db"
    }
}