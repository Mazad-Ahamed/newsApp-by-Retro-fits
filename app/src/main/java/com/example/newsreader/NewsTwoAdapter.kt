package com.example.newsreader

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsreader.Data.Article
import com.example.newsreader.databinding.ItemArticaltwoBinding
import com.example.newsreader.databinding.ItemArticleBinding


class NewsTwoAdapter (private val articles: List<Article>,

                   private val onItemClick : (Article) -> Unit

) :
    RecyclerView.Adapter<NewsTwoAdapter.NewsViewHolder>() {

    inner class NewsViewHolder(val binding: ItemArticaltwoBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemArticaltwoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = articles[position]
        holder.binding.NewsTitle.text = article.title

        Glide.with(holder.itemView).load(article.image).into(holder.binding.ivNewsimage)

        holder.itemView.setOnClickListener {
            onItemClick(article)
        }
    }

    override fun getItemCount() = articles.size
}