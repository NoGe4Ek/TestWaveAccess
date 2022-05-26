package com.poly.testwaveaccess.data.repositories

import com.poly.testwaveaccess.data.models.domainModel.User
import javax.inject.Singleton

@Singleton
interface UsersRepository {
    suspend fun cacheAndGetUsers(): List<User>

    suspend fun getUsers(): List<User>

    suspend fun getUser(id: Int): User

    suspend fun nukeTable()
}