package com.poly.testwaveaccess.ui.userList.mvi

import com.poly.testwaveaccess.mvi.Wish

sealed interface UserListWish: Wish {
    object Refresh: UserListWish
    object RefreshFromNetwork: UserListWish
}
