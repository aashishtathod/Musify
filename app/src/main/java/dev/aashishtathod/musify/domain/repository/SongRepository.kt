package dev.aashishtathod.musify.domain.repository

import dev.aashishtathod.musify.data.model.Song
import kotlinx.coroutines.flow.Flow

interface SongRepository {

    fun getDownloadedMusic(): Flow<List<Song>>

}