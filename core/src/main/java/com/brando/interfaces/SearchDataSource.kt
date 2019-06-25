package com.brando.interfaces

import com.brando.data.Result
import com.brando.data.models.Photo

/**
 * Class that allows loading data
 * Implementations of this class will handle how the data is retrieved and how pages are handled
 */
abstract class SearchDataSource {

    /**
     * Load more data from this source
     */
    abstract suspend fun loadSearchResults(searchQuery: String): Result<List<Photo>>
}
