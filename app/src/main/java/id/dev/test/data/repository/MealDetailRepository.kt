package id.dev.test.data.repository

import id.dev.test.base.BaseRepository
import id.dev.test.data.datastore.detail.MealDetailDataStore
import id.dev.test.model.MealDetail

class MealDetailRepository private constructor() : BaseRepository<MealDetailDataStore>() {

    suspend fun getMeals(id: Int): MutableList<MealDetail>? {
        val cache = localDataStore?.getMeals(id)
        if (cache != null) return cache
        val response = remoteDataStore?.getMeals(id)
        localDataStore?.addAll(id, response)
        return response
    }

    companion object {
        val instance by lazy { MealDetailRepository() }
    }
}