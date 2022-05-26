package com.poly.testwaveaccess.ui.userDetails.mvi

import com.poly.testwaveaccess.mvi.Wish

sealed interface UserDetailsWish: Wish {
    data class GetUserDetails(val userId: Int): UserDetailsWish

    data class ExternalEmail(val email: String): UserDetailsWish
    data class ExternalCall(val phone: String): UserDetailsWish
    data class ExternalMap(val latitude: String, val longitude: String): UserDetailsWish
}
