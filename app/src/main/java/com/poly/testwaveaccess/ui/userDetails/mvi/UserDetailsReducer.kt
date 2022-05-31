package com.poly.testwaveaccess.ui.userDetails.mvi

import android.widget.Toast
import com.poly.testwaveaccess.mvi.Reducer

class UserDetailsReducer: Reducer<UserDetailsState, UserDetailsEffect, UserDetailsNews> {

    override fun reduce(state: UserDetailsState, effect: UserDetailsEffect): Pair<UserDetailsState?, UserDetailsNews?> {
        var reducedState: UserDetailsState? = null
        var reducedNews: UserDetailsNews? = null
        when (effect) {
            is UserDetailsEffect.GetUserDetailsFailure -> {
                reducedNews = UserDetailsNews.Message(Toast.LENGTH_SHORT, effect.errorMessage)
            }
            is UserDetailsEffect.GetUserDetailsSuccess -> {
                reducedState = state.copy(user = effect.user, friends = effect.friends)
            }
            is UserDetailsEffect.ExternalCallFailure -> {
                reducedNews = UserDetailsNews.Message(Toast.LENGTH_SHORT, effect.errorMessage)
            }
            is UserDetailsEffect.ExternalEmailFailure -> {
                reducedNews = UserDetailsNews.Message(Toast.LENGTH_SHORT, effect.errorMessage)
            }
            is UserDetailsEffect.ExternalMapFailure -> {
                reducedNews = UserDetailsNews.Message(Toast.LENGTH_SHORT, effect.errorMessage)
            }
            is UserDetailsEffect.ExternalSuccess -> {
                //Do nothing, that's ok
            }
        }
        return reducedState to reducedNews
    }
}