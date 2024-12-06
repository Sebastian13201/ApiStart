package com.example.apistart.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apistart.data.api.RetrofitClient
import com.example.apistart.data.api.model.UserDetailModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewmodel: ViewModel() {

    private val userDetails : LiveData<UserDetailModel>
        get() = _userDetails
    val _userDetails : MutableLiveData<UserDetailModel> by lazy {
        MutableLiveData<UserDetailModel>()
    }

    fun fetchUser() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = RetrofitClient.apiInstance.getUser()
            _userDetails.postValue(result)

        }
    }

}