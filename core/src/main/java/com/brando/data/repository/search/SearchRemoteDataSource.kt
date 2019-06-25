package com.brando.data.repository.search

import com.brando.data.Result
import com.brando.data.api.ApiService
import com.brando.data.models.Photo
import java.io.IOException
import javax.inject.Inject

class SearchRemoteDataSource @Inject constructor (private val apiService: ApiService) {


    suspend fun search(query: String): Result<List<Photo>> {
        return try {
            val searchResults = apiService.search(query)
            val photos = searchResults.body()
            if (searchResults.isSuccessful) {
                return Result.Success(photos?.photo)
            } else {
                Result.Error(IOException("Error searching $query"))
            }
        } catch (e: Exception) {
            Result.Error(IOException("Error searching $query", e))
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: SearchRemoteDataSource? = null

        fun getInstance(service: ApiService): SearchRemoteDataSource {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: SearchRemoteDataSource(service).also { INSTANCE = it }
            }
        }
    }
}
