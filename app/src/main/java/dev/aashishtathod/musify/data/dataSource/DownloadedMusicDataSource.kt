package dev.aashishtathod.musify.data.dataSource

import android.content.Context
import android.provider.MediaStore
import dev.aashishtathod.musify.data.model.Song
import javax.inject.Inject

class DownloadedMusicDataSource @Inject constructor(private val context: Context) {

    fun getMusic(): List<Song> {
        val songList = mutableListOf<Song>()

        val projection = arrayOf(
            MediaStore.Audio.AudioColumns.DATA,
            MediaStore.Audio.AudioColumns.AUTHOR,
            MediaStore.Audio.AudioColumns.DISPLAY_NAME,
            MediaStore.Audio.AudioColumns.DURATION,
        )

        val query = context.applicationContext.contentResolver.query(
            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
            projection,
            null,
            null,
            null
        )

        query?.use { cursor ->

            val dataColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.DATA)
            val authorColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.AUTHOR)
            val displayNameColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.DISPLAY_NAME)
            val durationColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.DURATION)

            while (cursor.moveToNext()) {
                val data = cursor.getString(dataColumn)
                val author = cursor.getString(authorColumn)
                val displayName = cursor.getString(displayNameColumn)
                val duration = cursor.getString(durationColumn)

                songList.add(
                    Song(
                        title = displayName,
                        artist = author,
                        duration = duration.toLong(),
                        path = data
                    )
                )
            }
        }
        return songList
    }
}