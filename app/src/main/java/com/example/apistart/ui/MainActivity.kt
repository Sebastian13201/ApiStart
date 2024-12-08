package com.example.apistart.ui

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.apistart.R
import com.example.apistart.data.ResponseState
import com.example.apistart.data.api.model.UserDetailModel
import com.example.apistart.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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

        viewmodel.userDetails.observe(this, { response ->
            when (response) {
                is ResponseState.Loading -> updateLoadingUI()
                is ResponseState.Success -> updateSuccessUI(response.result)
                is ResponseState.Fail -> updateFailUI(response.error)
            }
        })

        viewmodel.fetchUser()

    }

    private fun updateLoadingUI() {
        binding.apply {
            progressCircular.visibility = View.VISIBLE
            tvUser.visibility = View.GONE
            tvText.text = "Loading. . ."
        }
    }

    private fun updateFailUI(error: String) {
        binding.apply {
            progressCircular.visibility = View.GONE
            tvUser.visibility = View.VISIBLE
            tvText.text = error
        }
    }

    private fun updateSuccessUI(response: UserDetailModel) {
        binding.apply {
            progressCircular.visibility = View.GONE
            tvUser.visibility = View.VISIBLE
            Glide.with(this@MainActivity)
                .load(response.results?.get(0)?.picture?.large)
                .placeholder(R.drawable.ic_launcher_foreground) //in case of loading or buffering
                .error(R.drawable.ic_launcher_background) //in case of failure
                .into(tvUser)

            tvText.text =
                "${response?.results?.get(0)?.name?.first}, \n${response?.results?.get(0)?.gender}, \n${
                    response?.results?.get(
                        0
                    )?.email
                }"
        }
    }
}