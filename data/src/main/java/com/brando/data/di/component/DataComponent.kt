package com.brando.data.di.component

import com.brando.data.di.module.ApiModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [ApiModule::class])
@Singleton
interface DataComponent {

}