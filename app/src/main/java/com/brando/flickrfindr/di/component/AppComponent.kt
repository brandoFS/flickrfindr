package com.brando.flickrfindr.di.component

import android.app.Application
import com.brando.FlickrFindrApplication
import com.brando.data.di.component.DataComponent
import com.brando.flickrfindr.di.AppScope
import com.brando.flickrfindr.di.module.ActivityModule
import com.brando.flickrfindr.di.module.NavigatorModule
import com.brando.search.di.FragmentModule
import com.brando.search.di.SearchModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = [ActivityModule::class, AndroidSupportInjectionModule::class,
        FragmentModule::class,
        NavigatorModule::class,
        SearchModule::class],
    dependencies = [DataComponent::class]
)

@AppScope
interface AppComponent : AndroidInjector<FlickrFindrApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun dataComponent(dataComponent: DataComponent): AppComponent.Builder
        fun build(): AppComponent
    }
}