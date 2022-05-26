package com.poly.testwaveaccess.ui.userDetails.mvi

import com.poly.testwaveaccess.data.models.domainModel.User
import com.poly.testwaveaccess.mvi.State

data class UserDetailsState(
    val user: User?,
    val friends: List<User>,
): State
