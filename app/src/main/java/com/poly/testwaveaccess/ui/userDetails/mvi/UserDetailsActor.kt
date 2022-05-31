package com.poly.testwaveaccess.ui.userDetails.mvi

import android.content.Intent
import android.net.Uri
import com.poly.testwaveaccess.App
import com.poly.testwaveaccess.data.models.domainModel.User
import com.poly.testwaveaccess.mvi.Actor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class UserDetailsActor: Actor<UserDetailsState, UserDetailsWish, UserDetailsEffect>() {

    override suspend fun effect(
        state: UserDetailsState,
        wish: UserDetailsWish
    ): Flow<UserDetailsEffect?> = flow {
        when (wish) {
            is UserDetailsWish.GetUserDetails -> {
                try {
                    val user = usersRepository.getUser(wish.userId)
                    val friends = mutableListOf<User>()
                    friends.addAll(usersRepository.getUsersByIds(user.friends))

                    emit(UserDetailsEffect.GetUserDetailsSuccess(user, friends))
                } catch (e: Exception) {
                    val errorMessage = e.message ?: "Unknown exception"
                    emit(UserDetailsEffect.GetUserDetailsFailure(errorMessage))
                }
            }

            is UserDetailsWish.ExternalEmail -> {
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:")
                    val emails: Array<String> = arrayOf(wish.email)
                    putExtra(Intent.EXTRA_EMAIL, emails)
                }
                intent.flags =
                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS
                try {
                    if (intent.resolveActivity(App.appContext.packageManager) != null) {
                        App.appContext.startActivity(intent)
                    } else {
                        emit(UserDetailsEffect.ExternalEmailFailure(
                            "There are no applications capable of processing the request"
                        ))
                    }
                } catch (e: Exception) {
                    val errorMessage = e.message ?: "Unknown exception"
                    emit(UserDetailsEffect.ExternalEmailFailure(errorMessage))
                }
                emit(UserDetailsEffect.ExternalSuccess)
            }

            is UserDetailsWish.ExternalCall -> {
                val intent = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:${wish.phone}")
                }
                intent.flags =
                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS
                try {
                    if (intent.resolveActivity(App.appContext.packageManager) != null) {
                        App.appContext.startActivity(intent)
                    } else {
                        emit(UserDetailsEffect.ExternalCallFailure(
                            "There are no applications capable of processing the request"
                        ))
                    }
                } catch (e: Exception) {
                    val errorMessage = e.message ?: "Unknown exception"
                    emit(UserDetailsEffect.ExternalCallFailure(errorMessage))
                }
                emit(UserDetailsEffect.ExternalSuccess)
            }

            is UserDetailsWish.ExternalMap -> {
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    val geo = "${wish.latitude}, ${wish.longitude}"
                    data = Uri.parse("geo:$geo")
                }
                intent.flags =
                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS
                try {
                    if (intent.resolveActivity(App.appContext.packageManager) != null) {
                        App.appContext.startActivity(intent)
                    } else {
                        emit(UserDetailsEffect.ExternalMapFailure(
                            "There are no applications capable of processing the request"
                        ))
                    }
                } catch (e: Exception) {
                    val errorMessage = e.message ?: "Unknown exception"
                    emit(UserDetailsEffect.ExternalMapFailure(errorMessage))
                }
                emit(UserDetailsEffect.ExternalSuccess)
            }
        }
    }.flowOn(Dispatchers.IO)
}