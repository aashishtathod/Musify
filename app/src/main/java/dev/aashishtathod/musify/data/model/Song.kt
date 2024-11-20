package dev.aashishtathod.musify.data.model

data class Song(
    val title: String,
    val artist: String? = null,
    val duration: Long,
    val path: String
)
