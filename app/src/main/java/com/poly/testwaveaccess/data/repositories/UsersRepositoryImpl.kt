package com.poly.testwaveaccess.data.repositories

import android.content.SharedPreferences
import com.poly.testwaveaccess.App
import com.poly.testwaveaccess.data.database.UsersDao
import com.poly.testwaveaccess.util.CacheMapper
import com.poly.testwaveaccess.data.models.domainModel.User
import com.poly.testwaveaccess.data.network.ApiUserRetrofit
import com.poly.testwaveaccess.ui.userList.UserListFragment
import com.poly.testwaveaccess.ui.userList.mvi.UserListWish
import com.poly.testwaveaccess.util.NetworkMapper
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val usersDao: UsersDao,
    private val usersRetrofit: ApiUserRetrofit,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper,
    ) : UsersRepository {

    override suspend fun spGetUsers(): List<User> {
        val settings: SharedPreferences = App.appContext.getSharedPreferences(PREFS_NAME, 0)
        val users = mutableListOf<User>()
        if (settings.getBoolean(SETTINGS_FIRST_TIME, true)) {
            users.addAll(cacheAndGetUsers())
            settings.edit().putBoolean(SETTINGS_FIRST_TIME, false).apply()
        } else {
            users.addAll(getUsers())
        }

        return users
    }

    override suspend fun cacheAndGetUsers(): List<User> {
        val networkUsers = usersRetrofit.get()
        val users = networkMapper.mapFromEntityList(networkUsers)
        usersDao.addUsers(cacheMapper.mapToEntityList(users))
//        for (user in users) {
//            usersDao.addUser(cacheMapper.mapToEntity(user))
//        }
        //val cachedUsers = usersDao.getUsers()
        //val usersFromCache = cacheMapper.mapFromEntityList(cachedUsers)
        return users
    }

    override suspend fun getUsers(): List<User> {
        val cachedUsers = usersDao.getUsers()
        return cacheMapper.mapFromEntityList(cachedUsers)
    }

    override suspend fun getUsersByIds(ids: List<Int>): List<User> {
        val cachedUsers = usersDao.getUsersByIds(ids)
        return cacheMapper.mapFromEntityList(cachedUsers)
    }

    override suspend fun getUser(id: Int): User {
        val cachedUser = usersDao.getUser(id)
        return cacheMapper.mapFromEntity(cachedUser)
    }

    //Temporary solution
    override suspend fun nukeTable() {
        usersDao.nukeTable()
    }

    companion object {
        private const val PREFS_NAME = "PrefsFile"
        private const val SETTINGS_FIRST_TIME = "first_time"
    }
}