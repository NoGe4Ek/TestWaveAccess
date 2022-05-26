package com.poly.testwaveaccess.ui.userList.mvi

import com.poly.testwaveaccess.common.Logger
import com.poly.testwaveaccess.mvi.Store
import com.poly.testwaveaccess.ui.userDetails.mvi.*
import javax.inject.Inject

class UserListStore @Inject constructor(
    logger: Logger
): Store<UserListState, UserListWish, UserListEffect, UserListNews>(logger) {
    init {
        actor = UserListActor()
        reducer = UserListReducer()
    }
}