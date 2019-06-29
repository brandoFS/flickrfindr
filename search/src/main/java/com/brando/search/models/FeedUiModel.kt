package com.brando.search.models

import com.brando.data.models.Photo

/**
 * UI model for feed data
 */
data class FeedUiModel(
    val items: List<Photo>
)

data class FeedProgressUiModel(
    val isLoading: Boolean
)