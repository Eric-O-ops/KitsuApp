package com.example.kitsuapperic.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kitsuapperic.base.BaseDiffUtilItemCallback
import com.example.kitsuapperic.databinding.ItemAnimeBinding
import com.example.kitsuapperic.models.anime.AnimeModel
import com.example.kitsuapperic.setupImageWithGlide

class AnimeAdapter :
    PagingDataAdapter<AnimeModel, AnimeAdapter.ViewHolder>(BaseDiffUtilItemCallback()) {

    class ViewHolder(private val binding: ItemAnimeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(model: AnimeModel?) = with(binding) {
            val title = model?.attributes?.titles?.en_jp
            val picture = model?.attributes?.posterImage?.small.toString()

            itemAnimeTitle.text = title
            itemAnimeImage.setupImageWithGlide(picture)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemAnimeBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}


