package com.example.apistart.Viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apistart.data.ResponseState
import com.example.apistart.data.api.ApiClient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import javax.inject.Inject

@HiltViewModel
class MainViewmodel @Inject constructor(
    val apiClient: ApiClient
) : ViewModel() {

    val userDetails: LiveData<ResponseState>
        get() = _userDetails
    private val _userDetails: MutableLiveData<ResponseState> by lazy {
        MutableLiveData<ResponseState>()
    }

    fun fetchUser() {
        try {
            //starting the API call
            _userDetails.postValue(ResponseState.Loading)

            //IO ->
            //Main ->
            viewModelScope.launch(Dispatchers.Main) {
                val result = apiClient.getUser()
                if (result.results.isNullOrEmpty()) {
                    _userDetails.postValue(ResponseState.Fail("No records found!"))
                } else {
                    _userDetails.postValue(ResponseState.Success(result))
                }
            }
        } catch (e: SocketTimeoutException) {
            _userDetails.postValue(ResponseState.Fail(e.message.toString()))
        } catch (e: Exception) {
            _userDetails.postValue(ResponseState.Fail(e.message.toString()))
        }

    }

}