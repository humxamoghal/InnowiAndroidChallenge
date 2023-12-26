package com.humxa.innowichallenge.feature.photo.domain.usecase

import com.google.common.truth.Truth
import com.humxa.innowichallenge.feature.photo.FakeDataProvider
import com.humxa.innowichallenge.feature.photo.domain.model.PhotoEntity
import com.humxa.innowichallenge.feature.photo.domain.model.PhotoTableData
import io.mockk.unmockkAll
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class GetPhotosTableDataUseCaseTest {

    private lateinit var getPhotosTableDataUseCase: GetPhotosTableDataUseCase
    private lateinit var fakeDataProvider: FakeDataProvider

    @Before
    fun setup() {
        getPhotosTableDataUseCase = GetPhotosTableDataUseCase()
        fakeDataProvider = FakeDataProvider()
    }

    @Test
    fun `invoke with empty photos list returns empty table data`() = runBlocking {
        val emptyPhotosList = emptyList<PhotoEntity>()
        val result = runBlocking { getPhotosTableDataUseCase.invoke(emptyPhotosList) }
        Truth.assertThat(result.size).isEqualTo(1)
        Truth.assertThat(PhotoTableData.HEADER("Title", "Thumbnail URL")).isEqualTo(result[0])
    }

    @Test
    fun `invoke with non-empty photos list generates correct table data`() = runBlocking {
        val photos = fakeDataProvider.photos
        val expectedTableData = fakeDataProvider.tableData
        val result = getPhotosTableDataUseCase.invoke(photos)
        Truth.assertThat(result.size).isEqualTo(expectedTableData.size)
        Truth.assertThat(result.filterIsInstance<PhotoTableData.ROW>().map { it.photo })
            .isEqualTo(photos)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }
}