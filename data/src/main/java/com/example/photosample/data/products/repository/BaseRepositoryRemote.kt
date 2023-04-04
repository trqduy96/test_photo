package com.example.photosample.data.products.repository

open class BaseRepositoryRemote<T : IRemoteDataSource>(
    val remoteDataSource: T
) : IRepository