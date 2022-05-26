package com.poly.testwaveaccess.ui.userDetails

import com.poly.testwaveaccess.ui.BaseViewModel
import com.poly.testwaveaccess.ui.userDetails.mvi.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class UserDetailsViewModel @Inject constructor(): BaseViewModel<UserDetailsState, UserDetailsWish, UserDetailsEffect, UserDetailsNews>() {

    private val initState = UserDetailsState(
        user = null,
        emptyList()
    )
    override val stateFlow = MutableStateFlow(initState)
    override val wishFlow = MutableSharedFlow<UserDetailsWish?>()
    override val effectFlow = MutableSharedFlow<UserDetailsEffect?>()
    override val newsFlow = MutableSharedFlow<UserDetailsNews>()

    @Inject override lateinit var store: UserDetailsStore
}