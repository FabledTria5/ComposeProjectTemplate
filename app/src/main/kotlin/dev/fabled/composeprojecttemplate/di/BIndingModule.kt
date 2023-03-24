package dev.fabled.composeprojecttemplate.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.fabled.composeprojecttemplate.navigation.AndroidNavigator
import dev.fabled.navigation.navigation_core.Navigator
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface SingletonBindings {

    @Binds
    @Singleton
    fun bindNavigator(androidNavigator: AndroidNavigator): Navigator

}