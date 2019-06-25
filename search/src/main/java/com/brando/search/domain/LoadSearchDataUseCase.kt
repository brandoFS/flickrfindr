
package com.brando.search.domain


class LoadSearchDataUseCase {

    /*private val searchDataSource = SearchDateSource()

    private val _searchResult = MutableLiveData<List<Photo>>()
    val searchResult: LiveData<List<Photo>>
        get() = _searchResult

    suspend operator fun invoke() {
        val deferredJobs = mutableListOf<Deferred<Unit>>()
        supervisorScope {
                deferredJobs.add(async {
                    val result = it.loadSearchResults()
                    if (result is Result.Success) {
                        val oldItems = _searchResult.value.orEmpty().toMutableList()
                       // val searchResult = getPlaidItemsForDisplay(oldItems, result.data)
                        _searchResult.postValue(searchResult)
                    }
                })

        }
        deferredJobs.awaitAll()
    }*/
}
