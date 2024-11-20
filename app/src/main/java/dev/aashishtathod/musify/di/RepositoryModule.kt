package dev.aashishtathod.musify.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.aashishtathod.musify.data.dataSource.DownloadedMusicDataSource
import dev.aashishtathod.musify.data.repositoryImpl.SongRepositoryImpl
import dev.aashishtathod.musify.domain.repository.SongRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideSongRepository(dataSource: DownloadedMusicDataSource): SongRepository {
        return SongRepositoryImpl(dataSource)
    }
}