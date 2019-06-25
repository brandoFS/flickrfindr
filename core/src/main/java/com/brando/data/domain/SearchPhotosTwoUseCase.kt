/*
package com.brando.data.domain

import com.brando.data.Result
import com.brando.data.models.Photo
import com.brando.data.repository.search.SearchRepository
import com.brando.interfaces.SearchDataSource
import com.brando.util.exhaustive
import javax.inject.Inject

*/
/**
 * Use case that searches for photos based on a query [PhotosRepository]
 *//*

class SearchPhotosTwoUseCase @Inject constructor(private val searchRepository: SearchRepository) {


    */
/*override suspend fun loadSearchResults(searchQuery: String): Result<List<Photo>> {
        val result = searchRepository.search(searchQuery)
        when (result) {
            is Result.Success -> {
                val photos = result.data //.map { it.toStory() }
                return Result.Success(photos)
            }
            is Result.Error -> return result
        }.exhaustive*//*

    }
}*/
