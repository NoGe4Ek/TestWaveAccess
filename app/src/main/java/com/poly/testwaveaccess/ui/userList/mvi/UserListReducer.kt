package com.poly.testwaveaccess.ui.userList.mvi

import android.widget.Toast
import com.poly.testwaveaccess.mvi.Reducer

class UserListReducer: Reducer<UserListState, UserListEffect, UserListNews> {

    override fun reduce(state: UserListState, effect: UserListEffect): Pair<UserListState?, UserListNews?> {
        var reducedState: UserListState? = null
        var reducedNews: UserListNews? = null
        when (effect) {
            is UserListEffect.RefreshInProcess -> {
                reducedState = state.copy(isLoading = effect.isLoading)
            }

            is UserListEffect.RefreshSuccess -> {
                reducedState = state.copy(isLoading = effect.isLoading, users = effect.users)
            }

            is UserListEffect.RefreshFailure -> {
                reducedState = state.copy(isLoading = effect.isLoading)
                reducedNews = UserListNews.Message(Toast.LENGTH_SHORT, effect.errorMessage)
            }
        }
        return reducedState to reducedNews
    }
}