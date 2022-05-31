package com.poly.testwaveaccess.ui.userList.mvi

import com.poly.testwaveaccess.data.models.domainModel.User
import com.poly.testwaveaccess.mvi.Effect

sealed interface UserListEffect: Effect {
    data class RefreshInProcess(val isLoading: Boolean = true): UserListEffect
    data class RefreshSuccess(val isLoading: Boolean = false, val users: List<User>): UserListEffect
    data class RefreshFailure(val isLoading: Boolean = false, val errorMessage: String): UserListEffect
}
