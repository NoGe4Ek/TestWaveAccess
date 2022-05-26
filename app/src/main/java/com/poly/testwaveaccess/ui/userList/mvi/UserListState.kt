package com.poly.testwaveaccess.ui.userList.mvi

import com.poly.testwaveaccess.data.models.domainModel.User
import com.poly.testwaveaccess.mvi.State

data class UserListState(
    val isLoading: Boolean,
    val users: List<User>,
): State
