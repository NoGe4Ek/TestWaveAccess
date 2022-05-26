package com.poly.testwaveaccess.util

abstract class EntityMapper <Entity, DomainModel>{

    abstract fun mapFromEntity(entity: Entity): DomainModel

    abstract fun mapToEntity(domainModel: DomainModel): Entity

    fun mapFromEntityList(entities: List<Entity>): List<DomainModel> {
        return entities.map { mapFromEntity(it) }
    }
}