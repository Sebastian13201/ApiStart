package com.example.apistart.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apistart.data.repository.Repository
import com.example.apistart.util.ResponseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import javax.inject.Inject

@HiltViewModel
class MainViewmodel @Inject constructor(
    val repository: Repository
) : ViewModel() {

    val userDetails: LiveData<ResponseState>
        get() = _userDetails
    private val _userDetails: MutableLiveData<ResponseState> by lazy {
        MutableLiveData<ResponseState>()
    }

    fun fetchUser() {
        _userDetails.postValue(ResponseState.Loading) // Notify the UI of the loading state

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = repository.getUser()
                if (result.drinks.isNullOrEmpty()) {
                    _userDetails.postValue(ResponseState.Fail("No records found!"))
                } else {
                    _userDetails.postValue(ResponseState.Success(result))
                }
            } catch (e: SocketTimeoutException) {
                _userDetails.postValue(ResponseState.Fail("Network timeout: ${e.message.toString()}"))
            } catch (e: Exception) {
                _userDetails.postValue(ResponseState.Fail("An error occurred: ${e.message.toString()}"))
            }
        }
    }

}