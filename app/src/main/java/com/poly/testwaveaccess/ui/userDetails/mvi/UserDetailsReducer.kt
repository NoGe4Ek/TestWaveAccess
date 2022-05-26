package com.poly.testwaveaccess.ui.userDetails.mvi

import com.poly.testwaveaccess.mvi.Reducer

class UserDetailsReducer: Reducer<UserDetailsState, UserDetailsEffect, UserDetailsNews> {

    override fun reduce(state: UserDetailsState, effect: UserDetailsEffect): Pair<UserDetailsState?, UserDetailsNews?> {
        var reducedState: UserDetailsState? = null
        var reducedNews: UserDetailsNews? = null
        when (effect) {
            is UserDetailsEffect.GetUserDetailsFailure -> {
                reducedNews = UserDetailsNews.Message(1000, effect.errorMessage)
            }
            is UserDetailsEffect.GetUserDetailsSuccess -> {
                reducedState = state.copy(user = effect.user, friends = effect.friends)
            }
            is UserDetailsEffect.ExternalCallFailure -> {
                reducedNews = UserDetailsNews.Message(1000, effect.errorMessage)
            }
            is UserDetailsEffect.ExternalEmailFailure -> {
                reducedNews = UserDetailsNews.Message(1000, effect.errorMessage)
            }
            is UserDetailsEffect.ExternalMapFailure -> {
                reducedNews = UserDetailsNews.Message(1000, effect.errorMessage)
            }
            is UserDetailsEffect.ExternalSuccess -> {
                //Do nothing, that's ok
            }
        }
        return reducedState to reducedNews
    }
}