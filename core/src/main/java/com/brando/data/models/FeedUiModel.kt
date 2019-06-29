package com.brando.data.models

/**
 * UI model for feed data
 */
data class FeedUiModel(
    val items: List<Photo>
)

data class FeedProgressUiModel(
    val isLoading: Boolean
)