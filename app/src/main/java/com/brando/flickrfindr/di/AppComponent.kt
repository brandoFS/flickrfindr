package com.brando.flickrfindr.di

import android.app.Application
import com.brando.FlickrFindrApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = [ActivityModule::class,
        AndroidSupportInjectionModule::class]
)

@AppScope
interface AppComponent : AndroidInjector<FlickrFindrApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): AppComponent.Builder
        fun build(): AppComponent
    }
}