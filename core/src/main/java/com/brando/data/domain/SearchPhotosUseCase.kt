package com.brando.data.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.brando.data.Result
import com.brando.data.models.Photo
import com.brando.data.repository.search.SearchRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.supervisorScope

/**
 * Use case that searches for photos based on a query [PhotosRepository]
 */
class SearchPhotosUseCase (private val searchRepository: SearchRepository) {

    private val _searchResult = MutableLiveData<List<Photo>>()
    val searchResult: LiveData<List<Photo>>
        get() = _searchResult


    suspend fun loadSearchResults(searchQuery: String) {
        // val deferredJobs = mutableListOf<Deferred<Unit>>()
        supervisorScope {
            async {
                val result = searchRepository.search(searchQuery)
                if (result is Result.Success) {
                    val oldItems = _searchResult.value.orEmpty().toMutableList()
                    val searchResult = result.data
                    _searchResult.postValue(searchResult)
                }

                /*when (result) {
                   is Result.Success -> {
                       val photos = result.data //.map { it.toStory() }
                       return Result.Success(photos)
                   }
                   is Result.Error -> return result
               }.exhaustive*/
            }
        }
    }
}