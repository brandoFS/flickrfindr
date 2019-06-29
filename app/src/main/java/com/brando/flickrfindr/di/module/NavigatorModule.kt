package com.brando.flickrfindr.di.module

import com.brando.flickrfindr.Navigator
import com.brando.flickrfindr.di.AppScope
import dagger.Module
import dagger.Provides

@Module
open class NavigatorModule {
    @Provides
    @AppScope
    fun Navigator(): Navigator = com.brando.flickrfindr.Navigator()
}
