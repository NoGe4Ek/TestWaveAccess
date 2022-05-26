package com.poly.testwaveaccess.data.network

import com.poly.testwaveaccess.data.models.networkModel.UserNetworkEntity
import retrofit2.http.GET

interface ApiUserRetrofit {

    @GET(Constants.USERS_URL)
    suspend fun get(): List<UserNetworkEntity>

}