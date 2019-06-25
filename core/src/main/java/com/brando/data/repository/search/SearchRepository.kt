package com.brando.data.repository.search

import com.brando.data.Result
import com.brando.data.models.Photo

class SearchRepository (private val remoteDataSource: SearchRemoteDataSource) {

    private val cache = mutableMapOf<Int, Photo>()


    suspend fun search(query: String) = getData { remoteDataSource.search(query) }

    private suspend fun getData(
        request: suspend () -> Result<List<Photo>>
    ): Result<List<Photo>> {
        val result = request()
        if (result is Result.Success) {
            result.data?.let { cache(it) }
        }
        return result
    }

    /*fun getPhoto(id: Int): Result<Photo> {
        val photo = cache[id]
        return if (photo != null) {
            Result.Success(photo)
        } else {
            Result.Error(IllegalStateException("Photo $id not cached"))
        }
    }*/

    private fun cache(data: List<Photo>) {
        data.associateTo(cache) { it.id to it }
    }

    companion object {
        @Volatile
        private var INSTANCE: SearchRepository? = null

        fun getInstance(remoteDataSource: SearchRemoteDataSource): SearchRepository {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: SearchRepository(remoteDataSource).also {
                    INSTANCE = it
                }
            }
        }
    }
}
