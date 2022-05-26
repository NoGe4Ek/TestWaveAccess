package com.poly.testwaveaccess.ui.userDetails.mvi

import com.poly.testwaveaccess.data.models.domainModel.User
import com.poly.testwaveaccess.mvi.Effect

sealed class UserDetailsEffect: Effect {
    data class GetUserDetailsSuccess(val user: User, val friends: List<User>): UserDetailsEffect()
    data class GetUserDetailsFailure(val errorMessage: String): UserDetailsEffect()

    object ExternalSuccess: UserDetailsEffect()
    data class ExternalEmailFailure(val errorMessage: String): UserDetailsEffect()
    data class ExternalCallFailure(val errorMessage: String): UserDetailsEffect()
    data class ExternalMapFailure(val errorMessage: String): UserDetailsEffect()
}
