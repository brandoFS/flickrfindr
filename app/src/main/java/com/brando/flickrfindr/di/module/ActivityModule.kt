package com.brando.flickrfindr.di.module

import com.brando.flickrfindr.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeActivityInjector(): MainActivity
}
