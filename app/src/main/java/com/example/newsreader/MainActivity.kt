package com.example.newsreader

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsreader.Api.RetrofitInstance
import com.example.newsreader.Data.NewsResponse
import com.example.newsreader.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)

        fetchNews()
    }

    private fun fetchNews() {
        RetrofitInstance.api.getTopHeadlines().enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    val newsList = response.body()!!.articles
                    binding.recyclerView.adapter = NewsAdapter(newsList){selectedArticle ->
                        val intent =
                            Intent(this@MainActivity, FullNewsActivity::class.java)
                        intent.putExtra("NewsData", selectedArticle)
                        startActivity(intent)
                    }
                } else {
                    Toast.makeText(this@MainActivity, "No data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}




