package dev.aashishtathod.musify.domain.usecase

import dev.aashishtathod.musify.data.model.Song
import dev.aashishtathod.musify.domain.repository.SongRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDownloadedMusicUseCase @Inject constructor(
    private val repository: SongRepository
) {
    operator fun invoke(): Flow<List<Song>> {
         return repository.getDownloadedMusic()
    }
}