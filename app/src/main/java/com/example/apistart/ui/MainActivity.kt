package com.example.apistart.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.apistart.R
import com.example.apistart.data.api.model.UserDetailModel
import com.example.apistart.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    val viewmodel: MainViewmodel by viewModels()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnGetUser.setOnClickListener {
            viewmodel.fetchUser()
        }

        viewmodel._userDetails.observe(this, { response ->
            updateUI(response)
        })

        viewmodel.fetchUser()

    }

    private fun updateUI(response: UserDetailModel) {
        binding.apply {
            //Using Glide
            Glide.with(this@MainActivity).load(response.results?.get(0)?.picture?.large)
                .into(findViewById(R.id.tvUser))

            findViewById<TextView>(R.id.tvText).text =
                "${response?.results?.get(0)?.name?.first}, \n${response?.results?.get(0)?.gender}, \n${
                    response?.results?.get(0)?.email
                }"
        }
        }

}