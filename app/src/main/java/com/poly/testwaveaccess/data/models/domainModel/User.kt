package com.poly.testwaveaccess.data.models.domainModel

data class User (
    val id: Int,
    val name: String,
    val age: String,
    val company: String,
    val email: String,
    val phone: String,
    val address: String,
    val about: String,
    val eyeColor: String,
    val favoriteFruit: String,
    val registered: String,
    val latitude: String,
    val longitude: String,
    val friends: List<Int>,
    val isActive: String,
)