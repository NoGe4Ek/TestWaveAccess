package com.poly.testwaveaccess.ui.userList.mvi

import com.poly.testwaveaccess.mvi.Actor
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class UserListActor : Actor<UserListState, UserListWish, UserListEffect>() {

    override suspend fun effect(
        state: UserListState,
        wish: UserListWish
    ): Flow<UserListEffect?> = flow {
        when (wish) {
            is UserListWish.RefreshFromNetwork -> {
                emit(UserListEffect.RefreshInProcess(true))
                try {
                    val users = usersRepository.cacheAndGetUsers()
                    if (users.isNotEmpty())
                        emit(
                            UserListEffect.RefreshSuccess(
                                false,
                                users,
                            )
                        )
                    else
                        emit(UserListEffect.RefreshFailure(false, "Users is missing"))

                } catch (e: Exception) {
                    val errorMessage = e.message ?: "Unknown exception"
                    emit(UserListEffect.RefreshFailure(false, errorMessage))
                }
            }

            is UserListWish.SmartRefresh -> {
                emit(UserListEffect.RefreshInProcess(true))
                try {
                    val users = usersRepository.spGetUsers()
                    if (users.isNotEmpty())
                        emit(
                            UserListEffect.RefreshSuccess(
                                false,
                                users,
                            )
                        )
                    else
                        emit(UserListEffect.RefreshFailure(false, "Local users is missing"))
                } catch (e: Exception) {
                    val errorMessage = e.message ?: "Unknown exception"
                    emit(UserListEffect.RefreshFailure(false, errorMessage))
                }

            }
        }
    }.flowOn(Dispatchers.IO)
}