package com.poly.testwaveaccess.ui.userDetails.mvi

import com.poly.testwaveaccess.mvi.News
import com.poly.testwaveaccess.ui.userList.mvi.UserListNews


sealed class UserDetailsNews: News {
    data class Message(val duration: Int, val content: String): UserDetailsNews()
}