package com.poly.testwaveaccess.ui.userList.mvi

import com.poly.testwaveaccess.mvi.News


sealed interface UserListNews: News {
    data class Message(val duration: Int, val content: String): UserListNews
}