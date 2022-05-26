package com.poly.testwaveaccess.ui.userDetails.mvi

import com.poly.testwaveaccess.common.Logger
import com.poly.testwaveaccess.mvi.Store
import com.poly.testwaveaccess.ui.userList.mvi.*
import javax.inject.Inject

class UserDetailsStore @Inject constructor(
    logger: Logger
): Store<UserDetailsState, UserDetailsWish, UserDetailsEffect, UserDetailsNews>(logger) {
    init {
        actor = UserDetailsActor()
        reducer = UserDetailsReducer()
    }
}