package com.geektech7.youtube.ui.playlist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech7.youtube.databinding.ItemPlaylistBinding
import com.geektech7.youtube.extensions.load
import com.geektech7.youtube.model.Item
import com.geektech7.youtube.model.Playlist

class PlaylistAdapter(private val data: Playlist): RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder>() {

    inner class PlaylistViewHolder(private val binding: ItemPlaylistBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: Item) {
            binding.imgPlaylist.load(item.snippet.thumbnails.default.url)
            binding.txtNameOfPlaylist.text = item.snippet.title
            binding.txtHowManyVideos.text = item.contentDetails.itemCount.toString() + " video series"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        val binding = ItemPlaylistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlaylistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        holder.bind(data.items[position])
    }

    override fun getItemCount(): Int {
        return data.items.size
    }

}