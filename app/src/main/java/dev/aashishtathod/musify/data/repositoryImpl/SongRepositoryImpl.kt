package dev.aashishtathod.musify.data.repositoryImpl

import dev.aashishtathod.musify.data.dataSource.DownloadedMusicDataSource
import dev.aashishtathod.musify.data.model.Song
import dev.aashishtathod.musify.domain.repository.SongRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SongRepositoryImpl @Inject constructor(
    private val downloadedMusicDataSource: DownloadedMusicDataSource
) : SongRepository {

    override fun getDownloadedMusic(): Flow<List<Song>> = flow {
        emit(downloadedMusicDataSource.getMusic())
    }

}