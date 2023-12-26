package com.humxa.innowichallenge.feature.photo.data.repository

import com.humxa.innowichallenge.feature.photo.FakeDataProvider
import com.humxa.innowichallenge.feature.photo.data.datasource.local.PhotoDao
import com.humxa.innowichallenge.feature.photo.data.datasource.remote.ApiService
import io.mockk.impl.annotations.MockK
import io.mockk.unmockkAll
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class PhotoRepositoryImplTest {

    @MockK
    private lateinit var photoDao: PhotoDao

    @MockK
    private lateinit var apiService: ApiService

    private lateinit var photoRepositoryImpl: PhotoRepositoryImpl

    private lateinit var fakeDataProvider: FakeDataProvider

    @Before
    fun setup() {
        fakeDataProvider = FakeDataProvider()
        photoDao = mock(PhotoDao::class.java)
        apiService = mock(ApiService::class.java)
        photoRepositoryImpl = PhotoRepositoryImpl(photoDao, apiService)
    }

    @Test
    fun `test downloadPhotos with non-empty localData`() = runBlocking {
        val localPhotos = fakeDataProvider.photos
        `when`(photoDao.getPhotos()).thenReturn(localPhotos)
        val result = photoRepositoryImpl.downloadPhotos()
        assertEquals(localPhotos, result)
    }

    @Test
    fun `test downloadPhotos with empty localData`() = runBlocking {
        `when`(photoDao.getPhotos()).thenReturn(emptyList())
        val responsePhotos = fakeDataProvider.photos
        `when`(apiService.getPhotos()).thenReturn(responsePhotos)
        `when`(photoDao.insertAllPhotos(responsePhotos)).thenReturn(LongArray(responsePhotos.size))
        val result = photoRepositoryImpl.downloadPhotos()
        assertEquals(responsePhotos, result)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }
}