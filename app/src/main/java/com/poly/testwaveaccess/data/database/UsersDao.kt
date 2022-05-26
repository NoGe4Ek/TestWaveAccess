package com.poly.testwaveaccess.data.database

import androidx.room.*
import com.poly.testwaveaccess.data.models.dbModel.UserCacheEntity

@Dao
interface UsersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(user: UserCacheEntity)

    @Query("SELECT * FROM users ORDER BY id ASC")
    suspend fun getUsers(): List<UserCacheEntity>

    @Query("SELECT * FROM users WHERE id = :id")
    suspend fun getUser(id: Int): UserCacheEntity

    @Query("DELETE FROM users")
    suspend fun nukeTable()
}