package com.poly.testwaveaccess.ui.userList.mvi

import com.poly.testwaveaccess.data.models.domainModel.User
import com.poly.testwaveaccess.mvi.Effect

sealed class UserListEffect: Effect {
    data class RefreshInProcess(val isLoading: Boolean = true): UserListEffect()
    data class RefreshSuccess(val isLoading: Boolean = false, val users: List<User>): UserListEffect()
    data class RefreshFailure(val isLoading: Boolean = false, val errorMessage: String): UserListEffect()
    data class RefreshFromNetworkInProcess(val isLoading: Boolean = true): UserListEffect()
    data class RefreshFromNetworkSuccess(val isLoading: Boolean = false, val users: List<User>): UserListEffect()
    data class RefreshFromNetworkFailure(val isLoading: Boolean = false, val errorMessage: String): UserListEffect()
}
