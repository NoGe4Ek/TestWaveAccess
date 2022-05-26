package com.poly.testwaveaccess.di

import com.poly.testwaveaccess.common.Logger
import com.poly.testwaveaccess.mvi.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class StoreModule {
    @Provides
    fun provideStore(
        logger: Logger
    ): Store<State, Wish, Effect, News> {
        return Store(logger)
    }

    @Provides
    fun provideLogger(): Logger {
        return Logger()
    }
}