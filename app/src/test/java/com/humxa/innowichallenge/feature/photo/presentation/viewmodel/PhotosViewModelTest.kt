package com.humxa.innowichallenge.feature.photo.presentation.viewmodel
import com.google.common.truth.Truth
import com.humxa.innowichallenge.feature.photo.FakeDataProvider
import com.humxa.innowichallenge.feature.photo.domain.model.ScreenState
import com.humxa.innowichallenge.feature.photo.domain.usecase.PhotosUseCases
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.unmockkAll
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class PhotosViewModelTest {

    @MockK
    private lateinit var useCases: PhotosUseCases
    private lateinit var viewModel: PhotosViewModel

    private val testDispatcher by lazy {
        TestCoroutineDispatcher()
    }

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(testDispatcher)
        viewModel = PhotosViewModel(useCases)
    }

    @Test
    fun `initial state is LOADING`() = runTest {
        Truth.assertThat(viewModel.screenState.value).isEqualTo(ScreenState.LOADING)
    }

    @Test
    fun `downloadPhotos update state with error if download failed`() = runTest {
        val state = ScreenState.ERROR("Error")
        coEvery { useCases.downloadPhotos() } returns flowOf(state)
        viewModel.downloadPhotos()
        Truth.assertThat(viewModel.screenState.value).isEqualTo(state)
    }

    @Test
    fun `downloadPhotos update state with success if download succeed`() = runTest {
        val state = ScreenState.SUCCESS(FakeDataProvider().photos)
        coEvery { useCases.downloadPhotos() } returns flowOf(state)
        coEvery { useCases.getTableData(any()) } returns FakeDataProvider().tableData
        viewModel.downloadPhotos()
        Truth.assertThat(viewModel.screenState.value).isEqualTo(state)
    }

    @Test
    fun ` if downloadPhotos succeed photos has been updated with filtered data`() = runBlocking {
        val state = ScreenState.SUCCESS(FakeDataProvider().photos)
        val photosFiltered = FakeDataProvider().tableData
        coEvery { useCases.downloadPhotos() } returns flowOf(state)
        coEvery { useCases.getTableData(any()) } returns photosFiltered
        viewModel.downloadPhotos()
        Truth.assertThat(viewModel.photos).isEqualTo(photosFiltered)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }
}