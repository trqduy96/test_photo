package com.example.photosample.data.products.repository

import androidx.annotation.AnyThread
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.photosample.data.BuildConfig
import com.example.photosample.data.products.entity.PhotoResponse
import com.example.photosample.data.service.UserService
import javax.inject.Inject

class PhotoRepository @Inject constructor(
    remoteDataSource: PhotoRemoteDataSource
) : BaseRepositoryRemote<PhotoRemoteDataSource>(remoteDataSource) {

    fun fetchPager(): Pager<Int, PhotoResponse> {
        return remoteDataSource.getPager()
    }

}

class PhotoRemoteDataSource @Inject constructor(
    private val userService: UserService
) : IRemoteDataSource {
    fun getPager(): Pager<Int, PhotoResponse> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = { PhotoPagingSource(userService) }
        )
    }
}

class PhotoPagingSource(
    private val userService: UserService,
) : PagingSource<Int, PhotoResponse>() {
    override fun getRefreshKey(state: PagingState<Int, PhotoResponse>): Int? = state.anchorPosition

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PhotoResponse> {
        if (params is LoadParams.Prepend) {
            return LoadResult.Page(
                data = listOf(),
                prevKey = null,
                nextKey = null
            )
        }
        return try {
            val key = if (params.key == null) PAGING_DEFAULT_PAGE_SIZE else params.key as Int
            val photoResult =
                userService.fetchPhoto(key, BuildConfig.API_KEY)
            LoadResult.Page(
                data = photoResult,
                prevKey = key - 20,
                nextKey = key + 20
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}

val pagingConfig: PagingConfig
    @AnyThread get() = PagingConfig(
        initialLoadSize = PAGING_DEFAULT_INITIAL_LOAD_SIZE_HINT,
        pageSize = PAGING_DEFAULT_PAGE_SIZE,
        prefetchDistance = PAGING_DEFAULT_PREFETCH_DISTANCE,
        enablePlaceholders = false
    )

private const val PAGING_DEFAULT_PAGE_SIZE = 20
private const val PAGING_DEFAULT_PREFETCH_DISTANCE = 15
private const val PAGING_DEFAULT_INITIAL_LOAD_SIZE_HINT = 20