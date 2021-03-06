package com.poly.testwaveaccess.util

import androidx.room.TypeConverter

class FriendsConverter {
    @TypeConverter
    fun fromFriends(friends: List<Int>): String {
        return friends.joinToString(separator = ",")
    }

    @TypeConverter
    fun toFriends(data: String): List<Int> {
        return data.split(",").map { it.toInt() }
    }
}