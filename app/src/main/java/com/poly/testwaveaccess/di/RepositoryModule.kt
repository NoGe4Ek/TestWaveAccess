package com.poly.testwaveaccess.di

import com.poly.testwaveaccess.data.repositories.UsersRepository
import com.poly.testwaveaccess.data.repositories.UsersRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Repositories will live same as the activity that requires them
 * Bind Interface to Impl
 */

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun providesUsersRepository(impl: UsersRepositoryImpl): UsersRepository
}