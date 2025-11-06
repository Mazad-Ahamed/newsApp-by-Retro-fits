package com.example.newsreader

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.newsreader.Data.Article
import com.example.newsreader.databinding.ActivityFullNewsBinding

class FullNewsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFullNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFullNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val News = intent.getSerializableExtra("NewsData") as? Article

        News?.let {
            binding.Published.text = it.publishedAt
            binding.headlines.text = it.title
            binding.description.text=it.description
            binding.Source.text = it.source.toString()
            Glide.with(this ).load(it.image).into(binding.newsimageView)
        }

    }
}