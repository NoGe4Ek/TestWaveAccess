package com.poly.testwaveaccess.ui.userList.mvi

import com.poly.testwaveaccess.mvi.Wish

sealed interface UserListWish: Wish {
    object SmartRefresh: UserListWish
    object RefreshFromNetwork: UserListWish
}
