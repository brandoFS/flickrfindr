/*
 * Copyright 2018 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.brando.search.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.brando.data.domain.SearchPhotosUseCase
import com.brando.search.models.FeedUiModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel(
) : ViewModel() {
    companion object {
        private const val TAG = "SEARCH_VIEW_MODEL"
    }

    private var searchPhotosData: SearchPhotosUseCase? = null

    private val searchQuery = MutableLiveData<String>()

    private val results = Transformations.switchMap(searchQuery) {
        //searchPhotosData = SearchPhotosUseCase(searchRepository)
        //loadSearchData = LoadSearchDataUseCase(factories, it)
        CoroutineScope(Dispatchers.Default).launch {
            searchPhotosData!!.loadSearchResults(searchQuery.toString())
        }
        return@switchMap searchPhotosData?.searchResult
    }

    val searchResults: LiveData<FeedUiModel> = Transformations.map(results) {
        FeedUiModel(it)
    }

    /*private val _searchProgress = MutableLiveData<FeedProgressUiModel>()
    val searchProgress: LiveData<FeedProgressUiModel>
        get() = _searchProgress*/

    fun searchFor(query: String) {
        searchQuery.value = query
    }

   /* fun loadMore() = viewModelScope.launch(dispatcherProvider.computation) {
        _searchProgress.postValue(FeedProgressUiModel(true))
        loadSearchData?.invoke()
        _searchProgress.postValue(FeedProgressUiModel(false))
    }*/

    fun clearResults() {
        searchPhotosData = null
    }
}
