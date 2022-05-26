package com.poly.testwaveaccess.mvi

import com.poly.testwaveaccess.App
import com.poly.testwaveaccess.data.repositories.UsersRepository
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow

abstract class Actor<S: State, W: Wish, E: Effect> constructor(
    val usersRepository: UsersRepository =
        EntryPointAccessors.fromApplication(App.appContext, StoreEntryPoint::class.java).usersRepository(),
) {

    abstract suspend fun effect(state: S, wish: W): Flow<E?>
    suspend operator fun invoke(state: S, wish: W) = effect(state, wish)

    @EntryPoint
    @InstallIn(SingletonComponent::class)
    interface StoreEntryPoint {
        fun usersRepository(): UsersRepository
    }
}