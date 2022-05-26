package com.poly.testwaveaccess.ui.userList

import com.poly.testwaveaccess.ui.BaseViewModel
import com.poly.testwaveaccess.ui.userList.mvi.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(): BaseViewModel<UserListState, UserListWish, UserListEffect, UserListNews>() {

    private val initState = UserListState(
        isLoading = false,
        users = emptyList(),
    )
    override val stateFlow = MutableStateFlow(initState)
    override val wishFlow = MutableSharedFlow<UserListWish?>()
    override val effectFlow = MutableSharedFlow<UserListEffect?>()
    override val newsFlow = MutableSharedFlow<UserListNews>()

    @Inject override lateinit var store: UserListStore
}