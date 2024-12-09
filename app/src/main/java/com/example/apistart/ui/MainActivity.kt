package com.example.apistart.ui

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apistart.R
import com.example.apistart.Viewmodel.MainViewmodel
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
            tvText.text = "Loading..."
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
            tvText.text = View.GONE.toString()
            progressCircular.visibility = View.GONE
            rvDisplay.visibility = View.VISIBLE

            val userList = response.results ?: emptyList()
            // Set the adapter for the RecyclerView
            rvDisplay.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = DisplayAdapter(userList) // Set the correct adapter
            }

        }
    }
}