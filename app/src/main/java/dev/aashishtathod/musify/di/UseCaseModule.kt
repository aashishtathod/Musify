package dev.aashishtathod.musify.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.aashishtathod.musify.domain.repository.SongRepository
import dev.aashishtathod.musify.domain.usecase.GetDownloadedMusicUseCase

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    fun provideGetDownloadedMusicUseCase(repository: SongRepository): GetDownloadedMusicUseCase {
        return GetDownloadedMusicUseCase(repository)
    }

}