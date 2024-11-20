package dev.aashishtathod.musify.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.aashishtathod.musify.data.dataSource.DownloadedMusicDataSource

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    fun provideDownloadedMusicDataSource(@ApplicationContext context: Context): DownloadedMusicDataSource {
        return DownloadedMusicDataSource(context)
    }
}