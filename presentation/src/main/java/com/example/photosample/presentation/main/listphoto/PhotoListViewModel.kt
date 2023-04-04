package com.example.photosample.presentation.main.listphoto


import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.photosample.data.products.entity.PhotoResponse
import com.example.photosample.data.products.repository.PhotoRepository
import com.example.photosample.domain.base.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class PhotoListViewModel @Inject constructor(
    private val repository: PhotoRepository
) : BaseViewModel() {
    private val mSearchKeyLiveData = MutableLiveData(SEARCH_KEY_DEFAULT)

    @OptIn(ExperimentalCoroutinesApi::class)
    val repositoryLiveData: LiveData<PagingData<PhotoResponse>> =
        mSearchKeyLiveData.asFlow().flatMapLatest {
            repository.fetchPager().flow.cachedIn(viewModelScope)
        }.asLiveData()

    fun search() {
        mSearchKeyLiveData.postValue(true)
    }

    companion object {
        private const val SEARCH_KEY_DEFAULT = false
    }
}