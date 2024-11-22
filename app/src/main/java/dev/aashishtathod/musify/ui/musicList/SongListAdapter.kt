package dev.aashishtathod.musify.ui.musicList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.aashishtathod.musify.data.model.Song
import dev.aashishtathod.musify.databinding.ItemMusicBinding

class SongListAdapter : ListAdapter<Song, SongListAdapter.SongViewHolder>(DIFF_UTIL) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMusicBinding.inflate(inflater, parent, false)
        return SongViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class SongViewHolder(
        private val binding: ItemMusicBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(song: Song) {
            binding.tvSongName.text = song.title
            binding.tvSingerName.text = song.artist

            /* Glide.with(binding.ivSongImage)
                 .load(song.)
                 .into(binding.ivSongImage)*/
        }
    }

    companion object {
        val DIFF_UTIL = object : DiffUtil.ItemCallback<Song>() {
            override fun areItemsTheSame(oldItem: Song, newItem: Song): Boolean {
                return true
            }

            override fun areContentsTheSame(oldItem: Song, newItem: Song): Boolean {
                return true
            }

        }
    }
}