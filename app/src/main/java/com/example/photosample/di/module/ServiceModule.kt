package com.example.photosample.di.module

import com.example.photosample.data.service.ServiceManager
import com.example.photosample.data.service.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun provideUserService(retrofit: Retrofit): UserService{
        return retrofit.create(UserService::class.java)
    }

    @Provides
    @Singleton
    fun provideServiceManager(userService: UserService): ServiceManager{
        return ServiceManager(userService)
    }
}