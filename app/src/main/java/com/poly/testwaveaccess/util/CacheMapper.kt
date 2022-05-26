package com.poly.testwaveaccess.util

import com.poly.testwaveaccess.data.models.domainModel.User
import com.poly.testwaveaccess.data.models.dbModel.UserCacheEntity
import com.poly.testwaveaccess.util.EntityMapper
import javax.inject.Inject

class CacheMapper @Inject constructor(): EntityMapper<UserCacheEntity, User>() {

    override fun mapFromEntity(entity: UserCacheEntity): User {
        return User(
            id = entity.id,
            name = entity.name,
            age = entity.age,
            company = entity.company,
            email = entity.email,
            phone = entity.phone,
            address = entity.address,
            about = entity.about,
            eyeColor = entity.eyeColor,
            favoriteFruit = entity.favoriteFruit,
            registered = entity.registered,
            latitude = entity.latitude,
            longitude = entity.longitude,
            friends = entity.friends,
            isActive = entity.isActive,
        )
    }

    override fun mapToEntity(domainModel: User): UserCacheEntity {
        return UserCacheEntity(
            id = domainModel.id,
            name = domainModel.name,
            age = domainModel.age,
            company = domainModel.company,
            email = domainModel.email,
            phone = domainModel.phone,
            address = domainModel.address,
            about = domainModel.about,
            eyeColor = domainModel.eyeColor,
            favoriteFruit = domainModel.favoriteFruit,
            registered = domainModel.registered,
            latitude = domainModel.latitude,
            longitude = domainModel.longitude,
            friends = domainModel.friends,
            isActive = domainModel.isActive,
        )
    }
}