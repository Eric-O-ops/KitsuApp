package com.example.kitsuapperic.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kitsuapperic.base.BaseDiffUtilItemCallback
import com.example.kitsuapperic.databinding.ItemMangaBinding
import com.example.kitsuapperic.models.manga.MangaModel
import com.example.kitsuapperic.setupImageWithGlide

class MangaAdapter :
    PagingDataAdapter<MangaModel, MangaAdapter.ViewHolder>(BaseDiffUtilItemCallback()) {

    class ViewHolder(private val binding: ItemMangaBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(model: MangaModel?) = with(binding) {
            val title = model?.attributes?.titles?.en_jp
            val picture = model?.attributes?.posterImage?.small.toString()

            itemMangaTitle.text = title
            itemMangaImage.setupImageWithGlide(picture)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMangaBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}