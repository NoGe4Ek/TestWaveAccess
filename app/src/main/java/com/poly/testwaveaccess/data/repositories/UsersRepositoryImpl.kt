package com.poly.testwaveaccess.data.repositories

import com.poly.testwaveaccess.data.database.UsersDao
import com.poly.testwaveaccess.util.CacheMapper
import com.poly.testwaveaccess.data.models.domainModel.User
import com.poly.testwaveaccess.data.network.ApiUserRetrofit
import com.poly.testwaveaccess.util.NetworkMapper
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val usersDao: UsersDao,
    private val usersRetrofit: ApiUserRetrofit,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper,
    ) : UsersRepository {

    override suspend fun cacheAndGetUsers(): List<User> {
        val networkUsers = usersRetrofit.get()
        val users = networkMapper.mapFromEntityList(networkUsers)
        for (user in users) {
            usersDao.addUser(cacheMapper.mapToEntity(user))
        }
        //val cachedUsers = usersDao.getUsers()
        //val usersFromCache = cacheMapper.mapFromEntityList(cachedUsers)
        return users
    }

    override suspend fun getUsers(): List<User> {
        val cachedUsers = usersDao.getUsers()
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
}